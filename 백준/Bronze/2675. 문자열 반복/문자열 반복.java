import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Scanner 객체를 생성하여 입력을 받습니다.
    Scanner scanner = new Scanner(System.in);
    
    // 테스트 케이스의 수를 입력 받습니다.
    int T = scanner.nextInt();

    // T개의 테스트 케이스를 처리하기 위해 반복문을 사용합니다.
    for (int t = 0; t < T; t++) {
      // 각 테스트 케이스마다 반복 횟수 R과 문자열 S를 입력 받습니다.
      int R = scanner.nextInt();  // 반복 횟수
      String S = scanner.next();  // 입력 문자열

      // 새로운 문자열 P를 생성하기 위해 StringBuilder 객체를 사용합니다.
      StringBuilder result = new StringBuilder();
      
      // 문자열 S의 각 문자를 처리하기 위해 반복합니다.
      for (char c : S.toCharArray()) {
        // 각 문자를 R번 반복하여 StringBuilder에 추가합니다.
        for (int i = 0; i < R; i++) {
          result.append(c);
        }
      }
      
      // 최종 결과 문자열을 출력합니다.
      System.out.println(result.toString());
    }

    // Scanner 객체를 닫아줍니다.
    scanner.close();
  }
}
