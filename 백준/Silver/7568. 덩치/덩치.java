/*
각 사람의 몸무게와 키를 바탕으로 덩치 등수를 계산하는 문제
덩치 등수는 자신보다 더 큰 덩치의 사람 수에 따라 결정
각 사람의 덩치 등수는 자신보다 더 큰 덩치의 사람 수에 1을 더한 값

첫 줄에는 사람의 수 𝑁이 주어진다.
𝑁은 2 이상 50 이하입니다.

𝑁개의 줄에는 각 사람의 몸무게 
𝑥와 키 𝑦가 주어진다. 𝑥와 𝑦는 10 이상 200 이하의 양의 정수

두 사람 A와 B의 덩치가 각각 
(𝑥𝐴,𝑦𝐴)와 
(𝑥𝐵,𝑦𝐵)로 주어졌을 때, 
𝑥𝐴 > 𝑥𝐵 그리고 
𝑦𝐴 > 𝑦𝐵 이면 A의 덩치가 B의 덩치보다 크다
만약 몸무게나 키 중 하나라도 같거나 작으면 덩치의 크기를 비교할 수 없다.

덩치 등수:
각 사람의 덩치 등수는 자신보다 큰 덩치의 사람 수에 1을 더한 값
예를 들어, 자신보다 큰 덩치의 사람이 3명이라면 덩치 등수는 4
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 줄에 주어진 사람의 수 N을 입력받고 정수로 변환
        int N = Integer.parseInt(br.readLine());
        // 사람들의 몸무게와 키를 저장할 2차원 배열 생성
        int[][] people = new int[N][2];
        
        // 사람들의 몸무게와 키 입력 받기
        for (int i = 0; i < N; i++) {
            // 한 줄씩 입력을 받고 공백으로 분리하여 각각 몸무게와 키를 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[i][0] = Integer.parseInt(st.nextToken()); // 몸무게
            people[i][1] = Integer.parseInt(st.nextToken()); // 키
        }
        
        // 각 사람의 덩치 등수를 저장할 배열 생성
        int[] ranks = new int[N];
        
        // 각 사람의 덩치 등수 계산하기
        for (int i = 0; i < N; i++) {
            int rank = 1; // 기본 등수는 1등으로 시작
            for (int j = 0; j < N; j++) {
                if (i != j) { // 자기 자신과 비교할 필요는 없음
                    // 다른 사람의 몸무게와 키가 모두 큰 경우
                    if (people[j][0] > people[i][0] && people[j][1] > people[i][1]) {
                        rank++; // 현재 사람의 등수를 증가
                    }
                }
            }
            // 현재 사람의 등수를 ranks 배열에 저장
            ranks[i] = rank;
        }
        
        // 결과 출력하기
        StringBuilder sb = new StringBuilder();
        for (int rank : ranks) {
            // 각 사람의 등수를 StringBuilder에 추가하고 공백으로 구분
            sb.append(rank).append(' ');
        }
        // 최종 결과를 출력 (마지막 공백을 제거하기 위해 trim() 사용)
        System.out.println(sb.toString().trim());
    }
}
