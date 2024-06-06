import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열의 길이 입력
        int L = Integer.parseInt(br.readLine());
        // 문자열 입력
        String str = br.readLine();

        // 해시 값 계산에 사용될 변수 초기화
        long hashValue = 0;
        long r = 1;
        long M = 1234567891;
        // 문자열의 각 알파벳에 대해 해시 값 계산
        for (int i = 0; i < L; i++) {
            int alphabet = str.charAt(i) - 'a' + 1; // 알파벳에 대응하는 숫자로 변환
            hashValue = (hashValue + (alphabet * r) % M) % M; // 해시 값 계산
            r = (r * 31) % M; // r의 거듭제곱 계산
        }

        // 계산된 해시 값 출력
        System.out.println(hashValue);

        br.close();
    }
}
