import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] coinValues = new int[N];

        for (int i = 0; i < N; i++) {
            coinValues[i] = scanner.nextInt();
        }

        // 최소 동전 개수 계산 및 출력
        int result = minCoinCount(N, K, coinValues);
        System.out.println(result);
    }

    public static int minCoinCount(int N, int K, int[] coinValues) {
        int count = 0;
        
        // 큰 가치의 동전부터 사용
        for (int i = N - 1; i >= 0; i--) {
            if (K == 0) {
                break;
            }
            count += K / coinValues[i];
            K %= coinValues[i];
        }
        return count;
    }
}