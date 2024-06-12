import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        
        String[] secondLine = br.readLine().split(" ");
        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(secondLine[i]);
        }

        // 결과 출력
        System.out.println(findBestSum(cards, N, M));
    }

    public static int findBestSum(int[] cards, int N, int M) {
        int bestSum = 0;

        // 모든 가능한 세 장의 카드 조합을 탐색
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    int currentSum = cards[i] + cards[j] + cards[k];
                    // 조건에 맞는 가장 큰 합을 찾기
                    if (currentSum <= M && currentSum > bestSum) {
                        bestSum = currentSum;
                    }
                }
            }
        }

        return bestSum;
    }
}
