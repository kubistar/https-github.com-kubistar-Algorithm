import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        // 코드1의 수행 횟수 계산
        long count = (long) n * (n - 1) / 2;
        
        // 최고차항의 차수 출력
        int degree = 2;
        if (degree > 3) {
            degree = 4;
        }
        
        // 결과 출력
        System.out.println(count);
        System.out.println(degree);
    }
}
