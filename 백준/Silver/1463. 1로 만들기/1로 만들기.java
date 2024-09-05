import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N 입력 받기
        int N = Integer.parseInt(br.readLine());
        
        // D
        int[] dp = new int[N + 1];
        
        // DP 계산 (1은 이미 0회로 만들 수 있음)
        for (int i = 2; i <= N; i++) {
            // 1을 빼는 경우
            dp[i] = dp[i - 1] + 1;
            
            // 2로 나누어 떨어지는 경우
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            
            // 3으로 나누어 떨어지는 경우
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        
        // 결과 출력
        System.out.println(dp[N]);
    }
}
