import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력을 읽기 위한 설정
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 입력 문자열을 한 줄 읽음
        String input = reader.readLine();

        // 입력 문자열의 길이
        int length = input.length();

        // 10글자씩 끊어서 출력
        for (int i = 0; i < length; i += 10) {
            // 시작 인덱스 i부터 끝 인덱스 i+10까지 부분 문자열을 추출
            if (i + 10 < length) {
                System.out.println(input.substring(i, i + 10));
            } else {
                // 남은 문자열의 길이가 10글자 미만인 경우
                System.out.println(input.substring(i));
            }
        }
    }
}