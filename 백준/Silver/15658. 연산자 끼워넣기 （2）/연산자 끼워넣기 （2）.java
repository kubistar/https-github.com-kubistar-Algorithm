import java.util.*;

public class Main {
    static int N;
    static int[] numbers;
    static int[] operators; // {+, -, *, /}
    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        operators = new int[4]; // +, -, *, /
        for (int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt();
        }

        // 백트래킹 시작
        backtrack(1, numbers[0]);

        // 결과 출력
        System.out.println(maxResult);
        System.out.println(minResult);
    }

    static void backtrack(int depth, int currentResult) {
        // 종료 조건: 수열의 모든 숫자를 사용한 경우
        if (depth == N) {
            maxResult = Math.max(maxResult, currentResult);
            minResult = Math.min(minResult, currentResult);
            return;
        }

        // 연산자들을 하나씩 사용
        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                // 연산자 사용
                operators[i]--;
                int nextResult = calculate(currentResult, numbers[depth], i);

                // 다음 단계로
                backtrack(depth + 1, nextResult);

                // 연산자 복구 (백트래킹)
                operators[i]++;
            }
        }
    }

    // 연산 수행
    static int calculate(int a, int b, int operator) {
        switch (operator) {
            case 0: return a + b; // 덧셈
            case 1: return a - b; // 뺄셈
            case 2: return a * b; // 곱셈
            case 3: return a / b; // 나눗셈 (정수 나눗셈)
            default: throw new IllegalArgumentException("Invalid operator");
        }
    }
}
