import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력을 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력된 한 줄의 문자열을 공백을 기준으로 나누어 배열에 저장
        String[] input = br.readLine().split(" ");
        
        // M과 N을 입력받아 정수로 변환
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        
        // 소수를 판별하기 위한 배열 생성
        // 배열의 크기를 N + 1로 설정하여 인덱스 0부터 N까지의 숫자를 다룰 수 있게 함
        boolean[] isPrime = new boolean[N + 1];
        
        // 초기화: 모든 수를 소수라고 가정
        // 인덱스 2부터 N까지를 true로 설정 (1은 소수가 아님)
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        // 에라토스테네스의 체 알고리즘 적용
        // 2부터 시작하여 특정 수 i의 배수들을 모두 소수가 아니라고 표시 (false)
        for (int i = 2; i * i <= N; i++) {  // i * i <= N 조건을 사용하여 i의 제곱까지만 검사
            if (isPrime[i]) {  // 현재 숫자 i가 소수인 경우에만 배수를 제거
                // i의 제곱부터 N까지의 모든 i의 배수를 false로 설정
                // i * i부터 시작하는 이유는 그 이전의 배수들은 이미 처리되었기 때문
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 결과 출력: M 이상 N 이하의 숫자 중 소수인 숫자를 출력
        StringBuilder sb = new StringBuilder();  // 출력 성능을 위해 StringBuilder 사용
        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {  // 소수로 판별된 숫자만 출력
                sb.append(i).append("\n");
            }
        }
        
        // 모든 결과를 한 번에 출력
        System.out.print(sb.toString());
    }
}
