import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 펼쳐진 카드의 개수 입력
        int n = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 consume

        // 각 과일의 종류와 개수를 저장할 Map 생성
        Map<String, Integer> fruitCount = new HashMap<>();

        // 카드 정보 읽어들이기
        for (int i = 0; i < n; i++) {
            String[] cardInfo = scanner.nextLine().split(" ");
            String fruit = cardInfo[0];
            int count = Integer.parseInt(cardInfo[1]);

            // HashMap에 과일 개수 더하기
            fruitCount.put(fruit, fruitCount.getOrDefault(fruit, 0) + count);
        }

        // 종을 쳐야 하는지 확인
        boolean shouldRing = false;
        for (int count : fruitCount.values()) {
            if (count == 5) {
                shouldRing = true;
                break;
            }
        }

        // 종을 쳐야 하는지 출력
        System.out.println(shouldRing ? "YES" : "NO");

        scanner.close();
    }
}
