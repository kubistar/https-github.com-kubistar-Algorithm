import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력을 받습니다.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        // 시간을 입력받습니다. 형식은 항상 "DD:DD:DD"입니다.
        String time = reader.readLine();
        
        // 입력받은 시간을 콜론(:)을 기준으로 분할하여 parts 배열에 저장합니다.
        String[] parts = time.split(":");
        
        // parts 배열의 각 부분을 정수형으로 변환하여 numbers 배열에 저장합니다.
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }
        
        // 가능한 시간 해석의 수를 세기 위한 변수를 초기화합니다.
        int count = 0;
        
        // 각 가능한 조합에 대해 시, 분, 초가 유효한지 확인합니다.
        // 조합 1: HH:MM:SS -> parts[0]:parts[1]:parts[2]
        if (isValidHour(numbers[0]) && isValidMinuteSecond(numbers[1]) && isValidMinuteSecond(numbers[2])) {
            count++;
        }
        // 조합 2: HH:SS:MM -> parts[0]:parts[2]:parts[1]
        if (isValidHour(numbers[0]) && isValidMinuteSecond(numbers[2]) && isValidMinuteSecond(numbers[1])) {
            count++;
        }
        // 조합 3: MM:HH:SS -> parts[1]:parts[0]:parts[2]
        if (isValidHour(numbers[1]) && isValidMinuteSecond(numbers[0]) && isValidMinuteSecond(numbers[2])) {
            count++;
        }
        // 조합 4: MM:SS:HH -> parts[1]:parts[2]:parts[0]
        if (isValidHour(numbers[1]) && isValidMinuteSecond(numbers[2]) && isValidMinuteSecond(numbers[0])) {
            count++;
        }
        // 조합 5: SS:HH:MM -> parts[2]:parts[0]:parts[1]
        if (isValidHour(numbers[2]) && isValidMinuteSecond(numbers[0]) && isValidMinuteSecond(numbers[1])) {
            count++;
        }
        // 조합 6: SS:MM:HH -> parts[2]:parts[1]:parts[0]
        if (isValidHour(numbers[2]) && isValidMinuteSecond(numbers[1]) && isValidMinuteSecond(numbers[0])) {
            count++;
        }
        
        // 가능한 시간 해석의 수를 출력합니다.
        System.out.println(count);
    }

    // 주어진 숫자가 유효한 시(hour)인지 확인하는 함수
    private static boolean isValidHour(int num) {
        return num >= 1 && num <= 12; // 시는 1부터 12까지의 값을 가집니다.
    }

    // 주어진 숫자가 유효한 분(minute) 또는 초(second)인지 확인하는 함수
    private static boolean isValidMinuteSecond(int num) {
        return num >= 0 && num <= 59; // 분과 초는 0부터 59까지의 값을 가집니다.
    }
}
