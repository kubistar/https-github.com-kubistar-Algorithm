import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 최대 n이 10이므로 dp 배열의 크기를 11로 설정
        int[] dp = new int[11];

        // 기본값 설정
        dp[0] = 1; // 0을 만드는 방법은 아무 것도 더하지 않는 한 가지 방법
        dp[1] = 1; // 1을 만드는 방법은 1 하나로 만드는 한 가지 방법
        dp[2] = 2; // 2를 만드는 방법은 1+1, 2 두 가지 방법
        dp[3] = 4; // 3을 만드는 방법은 1+1+1, 1+2, 2+1, 3 네 가지 방법

        // dp 점화식 계산
        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        // 테스트 케이스 수 입력
        int T = scanner.nextInt();

        // 각 테스트 케이스 처리
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            System.out.println(dp[n]);
        }

        scanner.close();
    }
}
