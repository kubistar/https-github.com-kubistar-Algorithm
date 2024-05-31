import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    // 재귀 호출의 실행 횟수를 세는 변수
    static int recursiveCalls = 0;
    // 동적 프로그래밍 호출의 실행 횟수를 세는 변수
    static int dynamicCalls = 0;

    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력을 받음
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        reader.close();

        // 재귀 호출을 이용하여 피보나치 수 계산
        fib(n);

        // 동적 프로그래밍을 이용하여 피보나치 수 계산
        fibonacci(n);

        // 결과 출력
        System.out.println(recursiveCalls + " " + dynamicCalls);
    }

    // 재귀 호출을 이용한 피보나치 함수
    public static int fib(int n) {
        // n이 1 또는 2인 경우 피보나치 수는 1
        if (n == 1 || n == 2) {
            // 코드 1이 실행되는 횟수를 증가
            recursiveCalls++;
            return 1;
        } else {
            // 그렇지 않은 경우 두 개의 재귀 호출을 통해 피보나치 수 계산
            return fib(n - 1) + fib(n - 2);
        }
    }

    // 동적 프로그래밍을 이용한 피보나치 함수
    public static int fibonacci(int n) {
        // 피보나치 수를 저장할 배열 생성
        int[] f = new int[n + 1];
        // 초기값 설정
        f[1] = f[2] = 1;
        // 3부터 n까지 반복하여 피보나치 수 계산
        for (int i = 3; i <= n; i++) {
            // 피보나치 수 계산
            f[i] = f[i - 1] + f[i - 2];
            // 코드 2가 실행되는 횟수를 증가
            dynamicCalls++;
        }
        // n번째 피보나치 수 반환
        return f[n];
    }
}
