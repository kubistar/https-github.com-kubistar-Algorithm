import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n];
            
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            System.out.println(maxStickerScore(n, stickers));
        }
    }
    
    private static int maxStickerScore(int n, int[][] stickers) {
        if (n == 1) {
            return Math.max(stickers[0][0], stickers[1][0]);
        }
        
        int[][] dp = new int[2][n];
        
        dp[0][0] = stickers[0][0];
        dp[1][0] = stickers[1][0];
        if (n > 1) {
            dp[0][1] = stickers[0][1] + dp[1][0];
            dp[1][1] = stickers[1][1] + dp[0][0];
        }
        
        for (int i = 2; i < n; i++) {
            dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + stickers[0][i];
            dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + stickers[1][i];
        }
        
        return Math.max(dp[0][n-1], dp[1][n-1]);
    }
}
