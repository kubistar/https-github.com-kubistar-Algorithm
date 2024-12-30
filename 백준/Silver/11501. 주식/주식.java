/*
입력
입력의 첫 줄에는 테스트케이스 수를 나타내는 자연수 T가 주어진다. 
각 테스트케이스 별로 첫 줄에는 날의 수를 나타내는 자연수 N(2 ≤ N ≤ 1,000,000)이 주어지고, 
둘째 줄에는 날 별 주가를 나타내는 N개의 자연수들이 공백으로 구분되어 순서대로 주어진다. 
날 별 주가는 10,000이하다.

출력
각 테스트케이스 별로 최대 이익을 나타내는 정수 하나를 출력
답은 부호있는 64bit 정수형으로 표현 가능
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine()); // 날의 수
            int[] prices = new int[N];

            // 주가 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            // 최대 이익 계산
            long maxProfit = 0; // 최대 이익
            int maxPrice = 0;  // 현재까지의 최대 주가

            // 뒤에서부터 탐색
            for (int i = N - 1; i >= 0; i--) {
                if (prices[i] > maxPrice) {
                    maxPrice = prices[i]; // 최대 주가 갱신
                } else {
                    maxProfit += maxPrice - prices[i]; // 이익 추가
                }
            }

            sb.append(maxProfit).append("\n");
        }
        
        System.out.print(sb.toString()); // 결과 출력
    }
}

