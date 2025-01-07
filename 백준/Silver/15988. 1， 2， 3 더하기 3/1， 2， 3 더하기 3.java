/*
입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 
각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. 
n은 양수이며 1,000,000보다 작거나 같다.

출력
각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 1,000,000,009로 나눈 나머지를 출력한다.

n = 1일 때 가능한 방법의 수는 1가지 (1)
n = 2일 때 가능한 방법의 수는 2가지 (1+1, 2)
n = 3일 때 가능한 방법의 수는 4가지 (1+1+1, 1+2, 2+1, 3)
n= 4일 때 가능한 방법의 수는 7가지
1+1+1+1
1+1+2
1+2+1
2+1+1
2+2
1+3
3+1

1을 더해서 n을 만드는 경우 dp[n-1]
2을 더해서 n을 만드는 경우 dp[n-2]
3을 더해서 n을 만드는 경우dp[n-3]

dp[n] = dp[n−1]+dp[n−2]+dp[n−3]
*/

import java.io.*;

public class Main {
    static final int MOD = 1_000_000_009;
    static int[] dp = new int[1_000_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // DP 배열 초기화
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        // 점화식 적용
        for (int i = 4; i <= 1_000_000; i++) {
            dp[i] = ((dp[i - 1] + dp[i - 2]) % MOD + dp[i - 3]) % MOD;
        }

        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 수
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }

        System.out.print(sb);
    }
}
