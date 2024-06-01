import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // N: B진법 수, B: 진법
        String N = scanner.next();
        int B = scanner.nextInt();

        // 결과 출력
        System.out.println(convertToDecimal(N, B));

        scanner.close();
    }

    public static int convertToDecimal(String N, int B) {
        int decimalValue = 0;
        int length = N.length();

        for (int i = 0; i < length; i++) {
            char digit = N.charAt(i);
            int value;

            if ('0' <= digit && digit <= '9') {
                value = digit - '0';
            } else {
                value = digit - 'A' + 10;
            }

            decimalValue = decimalValue * B + value;
        }

        return decimalValue;
    }
}
