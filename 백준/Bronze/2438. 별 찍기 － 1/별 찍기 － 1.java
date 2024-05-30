import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();

    for (int i = 1; i <= N; i++) {
      // 문자열 곱셈과 유사한 방식으로, i개의 '*'를 출력
      System.out.println("*".repeat(i));
    }
    
    scanner.close();
  }
}