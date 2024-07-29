import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int result = findSmallestConstructor(N);
        System.out.println(result);
    }

    private static int findSmallestConstructor(int N) {
        // 1부터 N-1까지 반복하면서 분해합이 N이 되는 가장 작은 생성자 찾기
        for (int i = 1; i < N; i++) {
            int decomposedSum = i + getDigitSum(i);
            if (decomposedSum == N) {
                return i; // 가장 작은 생성자를 찾으면 반환
            }
        }
        return 0; // 생성자가 없는 경우 0을 반환
    }

    private static int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
