/*
입력
fibonacci 함수에 인자로 입력할 n이 주어진다. (0 ≤ n ≤ 50)

출력
fibonacci 함수가 호출된 횟수를 출력한다.
출력값이 매우 커질 수 있으므로 정답을 1,000,000,007 로 나눈 나머지를 출력한다.

T(0)=1: fibonacci(0)은 한 번 호출
T(1)=1: fibonacci(1)도 한 번 호출

n >= 2
T(n)=T(n−1)+T(n−2)
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 입력값 n
        int MOD = 1_000_000_007;

        // n = 0일 경우 바로 출력
        if (n == 0) {
            System.out.println(1);
            return;
        }

        // DP 배열 초기화
        long[] dp = new long[n + 1];

        // 초기값 설정
        dp[0] = 1; // T(0) = 1
        dp[1] = 1; // T(1) = 1

        // 점화식을 이용해 DP 배열 채우기
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + 1) % MOD; // 나머지 연산
        }

        System.out.println(dp[n]);
    }
}
