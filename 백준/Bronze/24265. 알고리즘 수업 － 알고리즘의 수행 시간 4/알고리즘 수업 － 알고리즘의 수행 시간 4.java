import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 입력을 받음

        // 코드1의 수행 횟수 계산
        long count = (long) n * (n - 1) / 2;

        // 최고차항의 차수 계산
        int degree = 2;
        if (degree > 3) {
            degree = 4;
        }

        // 결과 출력
        System.out.println(count);
        System.out.println(degree);

        br.close();
    }
}
