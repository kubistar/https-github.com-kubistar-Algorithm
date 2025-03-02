import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 동전의 개수
        int k = Integer.parseInt(st.nextToken()); // 목표 금액

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k + 1];
        dp[0] = 1; // 초기값 설정 (0원을 만드는 방법 1가지)

        for (int coin : coins) {
            for (int j = coin; j <= k; j++) {
                dp[j] += dp[j - coin]; // 점화식 적용
            }
        }

        System.out.println(dp[k]); // k원을 만드는 경우의 수 출력
    }
}
