import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력을 받기 위한 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 배열의 크기 n을 입력으로 받음
        int n = Integer.parseInt(br.readLine());

        // 코드1의 실행 횟수 계산
        long count = calculateCount(n);

        // 최고차항의 차수 계산
        int degree = 3;

        // 결과 출력
        System.out.println(count); // 코드1의 실행 횟수 출력
        System.out.println(degree); // 최고차항의 차수 출력
    }

    // 코드1의 실행 횟수 계산하는 함수
    public static long calculateCount(int n) {
        // 코드1의 실행 횟수를 계산하여 반환
        // 조합의 공식을 사용하여 계산함
        return (long) n * (n - 1) * (n - 2) / 6;
    }
}
