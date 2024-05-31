import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력을 받기 위해 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력된 값을 정수형으로 변환하여 변수 n에 저장
        int n = Integer.parseInt(br.readLine()); // 입력을 받음

        // 코드1의 수행 횟수는 입력된 값 n과 동일
        int executionCount = n;
        // 코드1의 수행 횟수를 따로 계산할 필요 없이 입력된 값 n이 코드1의 수행 횟수가 됨

        // 다항식의 최고차항 차수는 1차항
        int degreeOfPolynomial = 1;
        // 주어진 알고리즘의 특성에 따라서 코드1의 수행 횟수를 나타내는 다항식의 최고차항이 1차항이 되는 것임
        // 코드1의 수행 횟수는 n이며, 이걸 다항식으로 나타내면 1차항이 됨

        // 결과 출력
        System.out.println(executionCount); // 코드1의 수행 횟수 출력
        System.out.println(degreeOfPolynomial); // 최고차항의 차수 출력

        // BufferedReader 사용 후 리소스를 반환하여 메모리 누수를 방지
        br.close();
    }
}
