/*
입력
N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. 
 (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)

출력
첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력

K보다 작거나 같은 가장 큰 동전을 찾음
그 동전으로 가능한 최대한 많이 사용
그 동전을 사용한 후 남은 금액에 대해 다시 같은 과정을 반복
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());      //  동전 가치
        int K = Integer.parseInt(st.nextToken());      // 동전 합
        
        // 동전 가치를 저장할 배열 생성
        int[] coinValues = new int[N];

        // N개의 동전 가치를 입력 
        for (int i = 0; i < N; i++) {
            coinValues[i] = Integer.parseInt(br.readLine());
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
