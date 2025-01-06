/*
입력
첫째 줄에 조카의 수 M (1 ≤ M ≤ 1,000,000), 과자의 수 N (1 ≤ N ≤ 1,000,000)이 주어진다.
둘째 줄에 과자 N개의 길이 L1, L2, ..., LN이 공백으로 구분되어 주어진다. 
과자의 길이는 (1 ≤ L1, L2, ..., LN ≤ 1,000,000,000) 를 만족한다.

출력
첫째 줄에 조카 1명에게 줄 수 있는 막대 과자의 최대 길이를 출력한다.
단, 모든 조카에게 같은 길이의 막대과자를 나눠줄 수 없다면, 0을 출력한다.
*/


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 조카 수(M)
        int N = Integer.parseInt(st.nextToken()); // 과자 수(N)

        // 과자 길이 배열
        int[] snacks = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
        }

        // 이분 탐색 범위 설정
        long left = 1; // 최소 길이
        long right = Arrays.stream(snacks).max().getAsInt(); // 최대 길이 (과자 중 가장 긴 길이)
        long result = 0;

        // 이분 탐색 시작
        while (left <= right) {
            long mid = (left + right) / 2; // 중간값(현재 시도하는 길이)

            if (canDistribute(snacks, M, mid)) {
                result = mid; // 가능하다면 길이 업데이트
                left = mid + 1; // 더 긴 길이 시도
            } else {
                right = mid - 1; // 불가능하면 길이를 줄임
            }
        }

        // 결과 출력
        System.out.println(result);
    }

    // 과자를 mid 길이로 나눠서 M명에게 줄 수 있는지 확인하는 함수
    public static boolean canDistribute(int[] snacks, int M, long mid) {
        if (mid == 0) return false; // 길이가 0이면 불가능

        int count = 0;
        for (int snack : snacks) {
            count += snack / mid; // 각 과자를 mid 길이로 나눈 조각 수 계산
        }
        return count >= M; // 조각 수가 조카 수보다 많거나 같으면 true
    }
}
