import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        String[] input = br.readLine().split(" ");
        String a = input[0];
        String b = input[1];

        // 문자열 뒤집기
        String reversedA = new StringBuilder(a).reverse().toString();
        String reversedB = new StringBuilder(b).reverse().toString();

        // 정수로 변환
        int reversedIntA = Integer.parseInt(reversedA);
        int reversedIntB = Integer.parseInt(reversedB);

        // 더 큰 수 출력
        System.out.println(Math.max(reversedIntA, reversedIntB));
    }
}