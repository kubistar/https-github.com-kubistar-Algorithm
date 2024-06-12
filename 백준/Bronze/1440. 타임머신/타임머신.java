import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String time = scanner.nextLine();
        scanner.close();
        
        String[] parts = time.split(":");
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }
        
        int count = 0;
        if (isValidHour(numbers[0]) && isValidMinuteSecond(numbers[1]) && isValidMinuteSecond(numbers[2])) {
            count++;
        }
        if (isValidHour(numbers[0]) && isValidMinuteSecond(numbers[2]) && isValidMinuteSecond(numbers[1])) {
            count++;
        }
        if (isValidHour(numbers[1]) && isValidMinuteSecond(numbers[0]) && isValidMinuteSecond(numbers[2])) {
            count++;
        }
        if (isValidHour(numbers[1]) && isValidMinuteSecond(numbers[2]) && isValidMinuteSecond(numbers[0])) {
            count++;
        }
        if (isValidHour(numbers[2]) && isValidMinuteSecond(numbers[0]) && isValidMinuteSecond(numbers[1])) {
            count++;
        }
        if (isValidHour(numbers[2]) && isValidMinuteSecond(numbers[1]) && isValidMinuteSecond(numbers[0])) {
            count++;
        }
        
        System.out.println(count);
    }

    private static boolean isValidHour(int num) {
        return num >= 1 && num <= 12;
    }

    private static boolean isValidMinuteSecond(int num) {
        return num >= 0 && num <= 59;
    }
}
