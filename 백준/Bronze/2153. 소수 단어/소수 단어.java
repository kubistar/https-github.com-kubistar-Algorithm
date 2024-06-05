import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력을 받습니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력된 단어를 저장합니다.
        String word = br.readLine();
        
        // 단어의 합을 계산할 변수를 선언합니다.
        int sum = 0;
        
        // 각 문자의 값을 계산하여 합을 구합니다.
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sum += c - 'a' + 1; // 소문자 a-z -> 1-26
            } else if (c >= 'A' && c <= 'Z') {
                sum += c - 'A' + 27; // 대문자 A-Z -> 27-52
            }
        }
        
        // 합이 소수인지 판별합니다.
        if (isPrime(sum)) {
            System.out.println("It is a prime word.");
        } else {
            System.out.println("It is not a prime word.");
        }
    }
    
    // 주어진 수가 소수인지 판별하는 함수입니다.
    public static boolean isPrime(int n) {
        // 1은 소수로 간주됩니다.
        if (n <= 1) return true;
        
        // 2와 3은 소수입니다.
        if (n <= 3) return true;
        
        // 짝수와 3의 배수는 소수가 아닙니다.
        if (n % 2 == 0 || n % 3 == 0) return false;
        
        // 5부터 √n까지 검사합니다.
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        
        return true;
    }
}
