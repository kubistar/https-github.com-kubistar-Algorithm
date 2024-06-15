import java.util.Scanner;

public class Main {

    // 아파트 각 층과 호수의 사람 수를 계산하는 메서드
    public static int[][] calculatePeople() {
        int maxK = 14;
        int maxN = 14;
        int[][] dp = new int[maxK + 1][maxN + 1];

        // 0층의 각 호수에 사람 수 초기화
        for (int i = 1; i <= maxN; i++) {
            dp[0][i] = i;
        }

        // DP를 이용하여 각 층의 사람 수 계산
        for (int k = 1; k <= maxK; k++) {
            for (int n = 1; n <= maxN; n++) {
                dp[k][n] = dp[k][n - 1] + dp[k - 1][n];
            }
        }

        return dp;
    }

    public static void main(String[] args) {
        // DP 테이블 미리 계산
        int[][] dp = calculatePeople();

        Scanner scanner = new Scanner(System.in);
        // 테스트 케이스 수 입력 받기
        int t = scanner.nextInt();

        // 결과 저장
        int[] results = new int[t];

        for (int i = 0; i < t; i++) {
            // 각 테스트 케이스에 대해 k층 n호 입력 받기
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            results[i] = dp[k][n];
        }
        scanner.close();

        // 결과 출력
        for (int result : results) {
            System.out.println(result);
        }
    }
}
