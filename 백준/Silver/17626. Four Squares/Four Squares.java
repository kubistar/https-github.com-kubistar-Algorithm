/*
입력
입력은 자연수 n을 포함하는 한 줄로 구성된다. 1 ≤ n ≤ 50,000

출력
합이 n과 같게 되는 제곱수들의 최소 개수를 한 줄에 출력


26은 5^2과 1^2의 합이다; 
또한 4^2 + 3^2 + 1^2으로 표현할 수도 있다. 
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // n 입력받기
        
        // dp 배열 생성 및 초기화
        int[] dp = new int[n + 1];  
        
        // dp 배열을 최댓값으로 초기화 (최소값을 찾기 위해)
        for (int i = 1; i <= n; i++) {
            dp[i] = i;  // i를 1^2의 합으로만 표현한다고 가정
        }

        // DP를 이용한 최소 제곱수 합 구하기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        // 결과 출력
        System.out.println(dp[n]);
    }
}
