/*
입력
첫째 줄에 집의 수 N이 자연수로 주어진다. (1≤N≤200,000) 
둘째 줄에 N채의 집에 위치가 공백을 기준으로 구분되어 1이상 100,000이하의 자연수로 주어진다.

출력
첫째 줄에 안테나를 설치할 위치의 값을 출력한다. 
단, 안테나를 설치할 수 있는 위치 값으로 여러 개의 값이 도출될 경우 가장 작은 값을 출력한다.

예를 들어, 안테나가 위치한 곳이 5이고, 집이 1, 5, 7, 9에 위치한다면:
거리:
집 1까지의 거리: |5 - 1| = 4
집 5까지의 거리: |5 - 5| = 0
집 7까지의 거리: |5 - 7| = 2
집 9까지의 거리: |5 - 9| = 4
총 거리 합: 4 + 0 + 2 + 4 = 10

안테나를 다른 위치에 설치하면 거리 합이 달라질 수 있다.
예를 들어, 안테나를 1에 설치하면:
거리:
집 1까지의 거리: |1 - 1| = 0
집 5까지의 거리: |1 - 5| = 4
집 7까지의 거리: |1 - 7| = 6
집 9까지의 거리: |1 - 9| = 8
총 거리 합: 0 + 4 + 6 + 8 = 18

집의 위치를 정렬한 후, 가운데 위치에 있는 값을 선택 ->  중앙값
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int n = Integer.parseInt(br.readLine()); // 집의 개수
        String[] input = br.readLine().split(" "); // 집의 위치 배열
        int[] houses = new int[n];
        
        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(input[i]);
        }

        //정렬
        Arrays.sort(houses);

        int median = houses[(n - 1) / 2]; // 중앙값 

        System.out.println(median);
    }
}
