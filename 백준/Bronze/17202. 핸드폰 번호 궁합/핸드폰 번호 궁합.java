import java.util.Scanner;

public class Main {

    public static String getCompatibility(String a, String b) {
        // 초기 숫자열 생성
        int[] combined = new int[16];
        for (int i = 0; i < 8; i++) {
            combined[2 * i] = Character.getNumericValue(a.charAt(i));
            combined[2 * i + 1] = Character.getNumericValue(b.charAt(i));
        }

        // 궁합 계산
        while (combined.length > 2) {
            int[] temp = new int[combined.length - 1];
            for (int i = 0; i < combined.length - 1; i++) {
                temp[i] = (combined[i] + combined[i + 1]) % 10;
            }
            combined = temp;
        }

        // 최종 결과 출력
        return String.format("%d%d", combined[0], combined[1]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 입력
        String a = scanner.nextLine().trim();
        String b = scanner.nextLine().trim();
        scanner.close();

        // 결과 출력
        System.out.println(getCompatibility(a, b));
    }
}
