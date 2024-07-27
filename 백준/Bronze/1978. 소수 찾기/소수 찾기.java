import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄에서 수의 개수 N을 입력받음
        int N = Integer.parseInt(br.readLine());
        
        // 다음 줄에서 N개의 수를 입력받음
        String[] numbers = br.readLine().split(" ");
        
        int primeCount = 0;
        
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(numbers[i]);
            if (isPrime(number)) {
                primeCount++;
            }
        }
        
        // 결과 출력
        System.out.println(primeCount);
    }
    
    // 소수 여부를 확인하는 함수
    public static boolean isPrime(int num) {
        if (num <= 1) return false; // 1 이하는 소수가 아님
        if (num == 2) return true;  // 2는 소수
        if (num % 2 == 0) return false; // 2를 제외한 짝수는 소수가 아님
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}