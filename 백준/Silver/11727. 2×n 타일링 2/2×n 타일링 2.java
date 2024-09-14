/*
2×n 직사각형을 1×2, 2×1과 2×2 타일로 채우는 방법의 수를 구하는 프로그램을 작성

입력
첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)

출력
첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력



n=1일 때: 2×1 크기의 직사각형을 채우는 방법은 한 가지
dp[1] = 1

n=2일 때: 2×2 크기의 직사각형을 채우는 방법은 세 가지입니다.

세로로 1×2 타일을 두 개 놓는 방법
가로로 2×1 타일을 두 개 놓는 방법
2×2 타일을 한 번에 놓는 방법
dp[2] = 3


n이 3일 때
첫번째 경우 : 1×2 타일을 세로로 하나 배치하면, 남은 공간은 2×2 크기의 사각형 ->  dp[2]

두 번째 경우: 가로로 2×1 타일 두 개를 놓는 경우
남은 공간은 2×1 크기의 직사각형 -> dp[1] * 2
dp[3]=dp[2]+2×dp[1]=3+2×1=5

dp[n]=dp[n−1]+2×dp[n−2]



*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // DP 테이블 생성
        int[] dp = new int[Math.max(3, n + 1)];
        dp[1] = 1;  // 2×1을 채우는 방법은 1가지
        dp[2] = 3;  // 2×2를 채우는 방법은 3가지

        // DP 점화식을 이용해 계산
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + 2 * dp[i-2]) % 10007;
        }
        
        // 결과 출력
        System.out.println(dp[n]);
    }
}
