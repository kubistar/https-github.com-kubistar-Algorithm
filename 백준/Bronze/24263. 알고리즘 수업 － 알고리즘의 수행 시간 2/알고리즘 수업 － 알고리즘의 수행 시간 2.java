import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 입력을 받음

        // 코드1의 수행 횟수는 n번
        int executionCount = n;

        // 다항식의 최고차항 차수는 1차항
        int degreeOfPolynomial = 1;

        System.out.println(executionCount); // 수행 횟수 출력
        System.out.println(degreeOfPolynomial); // 최고차항의 차수 출력

        br.close();
    }
}
