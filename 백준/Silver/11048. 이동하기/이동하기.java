import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N (행), M (열) 입력 받기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 사탕 배열 및 DP 배열 초기화
        int[][] candy = new int[N][M];
        int[][] dp = new int[N][M];

        // 사탕 정보 입력 
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                candy[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // DP 배열
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 현재 위치의 사탕 개수
                dp[i][j] = candy[i][j];

                // 위쪽에서 오는 경우
                if (i > 0) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + candy[i][j]);

                // 왼쪽에서 오는 경우
                if (j > 0) dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + candy[i][j]);

                // 왼쪽 위 대각선에서 오는 경우
                if (i > 0 && j > 0) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + candy[i][j]);
            }
        }

        // (N, M)에서의 최대 사탕 개수 출력
        System.out.println(dp[N - 1][M - 1]);
    }
}
