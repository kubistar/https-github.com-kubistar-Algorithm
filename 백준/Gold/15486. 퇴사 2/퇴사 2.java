import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N + 1];  //  상담을 완료하는데 걸리는 기간 
        int[] P = new int[N + 1];  //  상담을 했을 때 받을 수 있는 금액
        int[] dp = new int[N + 2]; // N+1일까지의 최대 이익 저장

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            // 상담을 하지 않는 경우 
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            // 상담을 하는 경우 (상담이 N일을 넘지 않는 경우만)
            if (i + T[i] <= N + 1) {
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }
        }

        System.out.println(dp[N + 1]);
    }
}
