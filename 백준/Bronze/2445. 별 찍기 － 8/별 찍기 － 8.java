import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();
        
        StringBuilder sb = new StringBuilder();

        // 위쪽 절반
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                sb.append("*");
            }
            for (int j = 1; j <= (2 * N - 2 * i); j++) {
                sb.append(" ");
            }
            for (int j = 1; j <= i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        // 아래쪽 절반
        for (int i = N - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                sb.append("*");
            }
            for (int j = 1; j <= (2 * N - 2 * i); j++) {
                sb.append(" ");
            }
            for (int j = 1; j <= i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

}
