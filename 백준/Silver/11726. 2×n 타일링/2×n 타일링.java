/*
2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수

입력
첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)

출력
첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지

n = 1: 2×1 크기의 직사각형을 채우는 방법은 한 가지

n = 2: 2×2 크기의 직사각형을 채우는 방법은 두 가지
(세로로 1×2 타일 2개를 놓거나, 가로로 2×1 타일 2개를 놓는 경우)

n = 3:
마지막에 2×1 타일을 세로로 하나 놓는다면, 그 앞에는 2×2 직사각형을 채우는 방법이 남는다. 
이 경우는 f(2)와 동일
마지막에 1×2 타일 두 개를 가로로 놓는다면, 그 앞에는 2×1 직사각형을 채우는 방법이 남는다. 
이 경우는 f(1)과 동일
따라서, f(3) = f(2) + f(1)

n = 4:
마지막에 2×1 타일 하나를 세로로 놓는다면, 
그 앞에는 2×3 직사각형을 채우는 방법이 남는다. 이 경우는 f(3)과 동일
마지막에 1×2 타일 두 개를 가로로 놓는다면, 그 앞에는 2×2 직사각형을 채우는 방법이 남는다. 
이 경우는 f(2)와 동일 따라서, f(4) = f(3) + f(2)

f(n) = f(n-1) + f(n-2)
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // n 입력 받기
        int n = Integer.parseInt(br.readLine());
        
        // dp 배열 선언 (최대 1000까지 가능)
        int[] dp = new int[n + 1];
        
        // 초기값 설정
        dp[1] = 1;
        if (n > 1) {
            dp[2] = 2;
        }
        
        // 점화식에 따라 dp 채우기
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        
        // 결과 출력
        System.out.println(dp[n]);
    }
}
