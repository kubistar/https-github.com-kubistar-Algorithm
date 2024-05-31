import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // 코드1의 실행 횟수 계산
        long count = calculateCount(n);

        // 최고차항의 차수 계산
        int degree = 3;

        // 결과 출력
        System.out.println(count); // 코드1의 실행 횟수 출력
        System.out.println(degree); // 최고차항의 차수 출력
    }

    // 코드1의 실행 횟수 계산
    public static long calculateCount(int n) {
        return (long) n * (n - 1) * (n - 2) / 6;
    }
}
