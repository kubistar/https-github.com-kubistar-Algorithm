import java.util.Scanner;

public class Main {
    static int recursiveCalls = 0;
    static int dynamicCalls = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // Calculate using recursive method
        fib(n);

        // Calculate using dynamic programming method
        fibonacci(n);

        // Print results
        System.out.println(recursiveCalls + " " + dynamicCalls);
    }

    // Recursive Fibonacci function
    public static int fib(int n) {
        if (n == 1 || n == 2) {
            recursiveCalls++;
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    // Dynamic Programming Fibonacci function
    public static int fibonacci(int n) {
        int[] f = new int[n + 1];
        f[1] = f[2] = 1;
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
            dynamicCalls++;
        }
        return f[n];
    }
}
