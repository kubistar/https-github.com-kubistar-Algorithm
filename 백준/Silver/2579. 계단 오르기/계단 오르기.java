/*
입력
첫째 줄에 계단의 개수가 주어진다.

둘째 줄부터 한 줄에 하나씩 제일 아래에 놓인 계단부터 순서대로 각 계단에 쓰여 있는 점수가 주어진다. 
계단의 개수: 1 ≤ 계단의 개수 ≤ 300
계단에 쓰여 있는 점수: 1 ≤ 각 계단에 쓰여 있는 점수 ≤ 10,000

출력
규칙을 따르면서 계단을 오르면서 얻을 수 있는 최대 점수
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입력을 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 계단의 개수 입력 받기
        int n = Integer.parseInt(br.readLine());

        // 점수 배열 선언 및 초기화
        int[] score = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        // 계단이 하나만 있을 경우 예외 처리
        if (n == 1) {
            System.out.println(score[1]);
            return;
        }

        // dp 배열 선언
        int[] dp = new int[n + 1];

        // 초기 값 설정
        dp[1] = score[1];
        dp[2] = score[1] + score[2];

        // 동적 계획법 점화식을 이용한 계산
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + score[i], dp[i - 3] + score[i - 1] + score[i]);
        }

        // 결과 출력
        System.out.println(dp[n]);
    }
}
