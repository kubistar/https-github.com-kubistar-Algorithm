import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력을 받습니다.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        // 한 줄의 입력을 읽고 공백을 기준으로 분리합니다.
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        
        // 첫 번째 토큰은 K, 두 번째 토큰은 L입니다.
        BigInteger K = new BigInteger(tokenizer.nextToken());
        int L = Integer.parseInt(tokenizer.nextToken());
        
        // L보다 작은 소수 중에서 K의 인수를 찾습니다.
        for (int i = 2; i < L; i++) {
            // i가 소수인지 확인합니다.
            if (isPrime(i)) {
                // i가 K의 인수인지 확인합니다.
                if (K.mod(BigInteger.valueOf(i)).equals(BigInteger.ZERO)) {
                    // i가 K의 인수인 경우 BAD와 i를 출력합니다.
                    System.out.println("BAD " + i);
                    return;
                }
            }
        }
        
        // L보다 작은 인수가 없는 경우 GOOD을 출력합니다.
        System.out.println("GOOD");
    }
    
    // 주어진 숫자가 소수인지 판별하는 함수
    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }
}
