/*
n=0: 1 (아무것도 놓지 않는 방법)
n=1: 1 (2×1 타일 하나)
n=2: 3 (2×1 타일 두 개, 2×2 타일 하나)
𝑛=3 :
2×1 타일 3개 (1가지)
2×2 타일 1개 + 2×1 타일 1개 (2가지)
→ 총 5가지
𝑛 = 4 :
2×1 타일 4개 (1가지)
2×2 타일 1개 + 2×1 타일 2개 (3가지)
2×2 타일 2개 (2가지)
→ 총 11가지

마지막에 2×1 타일을 추가하는 경우
2×(n−1) 직사각형과 동일한 형태 → f(n−1)

마지막에 2×2 타일을 추가하는 경우
2×(n−2) 직사각형과 동일한 형태 → 𝑓(n−2)
*/

import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;

        // DP 배열 생성 
        int maxN = 250;
        BigInteger[] dp = new BigInteger[maxN + 1];
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;

        for (int i = 2; i <= maxN; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.TWO));
        }

        // 입력 처리 및 출력
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            int n = Integer.parseInt(line.trim());
            sb.append(dp[n]).append("\n");
        }

        System.out.print(sb);
    }
}
