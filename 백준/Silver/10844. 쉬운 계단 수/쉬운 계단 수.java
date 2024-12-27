/*
입력
첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.

출력
첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력


*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(reader.readLine()); // 입력값 N
        int MOD = 1_000_000_000;

        // dp[i][j]: 길이가 i이고 마지막 숫자가 j인 계단 수의 개수
        int[][] dp = new int[N + 1][10];

        // 초기값 설정 (길이가 1인 계단 수)
        for (int j = 1; j <= 9; j++) {
            dp[1][j] = 1;
        }

        // DP 테이블 채우기
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j > 0) dp[i][j] += dp[i - 1][j - 1]; // j-1에서 j로 오는 경우
                if (j < 9) dp[i][j] += dp[i - 1][j + 1]; // j+1에서 j로 오는 경우
                dp[i][j] %= MOD; // 나머지 연산
            }
        }

        // 길이가 N인 모든 계단 수의 합 계산
        int result = 0;
        for (int j = 0; j <= 9; j++) {
            result = (result + dp[N][j]) % MOD;
        }

        // 결과 출력
        System.out.println(result);
    }
}
