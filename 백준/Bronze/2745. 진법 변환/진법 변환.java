import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader 객체를 생성하여 사용자 입력을 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에 B진법 수 N과 진법 B를 입력 받음
        String input = br.readLine();  // 한 줄의 입력을 문자열로 받음
        String[] parts = input.split(" ");  // 입력을 공백 기준으로 나눔
        String N = parts[0];  // 첫 번째 부분은 B진법 수 N
        int B = Integer.parseInt(parts[1]);  // 두 번째 부분은 진법 B (정수로 변환)

        // B진법 수 N을 10진법으로 변환하여 결과를 출력
        System.out.println(convertToDecimal(N, B));

        // BufferedReader 객체를 닫아줌
        br.close();
    }

    // B진법 수 N을 10진법으로 변환하는 함수
    public static int convertToDecimal(String N, int B) {
        int decimalValue = 0;  // 결과값을 저장할 변수 초기화
        int length = N.length();  // 문자열 N의 길이를 저장

        // 문자열 N의 각 자릿수를 처리하기 위해 반복
        for (int i = 0; i < length; i++) {
            char digit = N.charAt(i);  // 현재 자릿수를 나타내는 문자
            int value;

            // 현재 자릿수가 숫자인 경우
            if ('0' <= digit && digit <= '9') {
                value = digit - '0';  // 문자를 숫자로 변환 (예: '3' -> 3)
            } else {  // 현재 자릿수가 문자(A-Z)인 경우
                value = digit - 'A' + 10;  // 문자를 숫자로 변환 (예: 'A' -> 10, 'B' -> 11)
            }

            // 10진법 값 계산
            decimalValue = decimalValue * B + value;
        }

        // 최종 10진법 값을 반환
        return decimalValue;
    }
}
