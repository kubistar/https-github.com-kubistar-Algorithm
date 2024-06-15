import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int[] A = new int[N];
        
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        
        // DP 배열 초기화
        int[] dp = new int[N];
        
        // 각 위치에서 길이는 최소 1
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }
        
        // DP로 가장 긴 감소하는 부분 수열의 길이를 계산
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] > A[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        // 결과는 dp 배열의 최대값
        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] > maxLength) {
                maxLength = dp[i];
            }
        }
        
        System.out.println(maxLength);
        
        scanner.close();
    }
}
