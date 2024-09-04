import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 피보나치 0과 1이 출력되는 횟수를 저장하는 배열
        int[][] fibCounts = new int[41][2];
        
        // 기본 값 초기화
        fibCounts[0][0] = 1;  // fibonacci(0)은 0이 1번 출력
        fibCounts[0][1] = 0;  // fibonacci(0)은 1이 0번 출력
        fibCounts[1][0] = 0;  // fibonacci(1)은 0이 0번 출력
        fibCounts[1][1] = 1;  // fibonacci(1)은 1이 1번 출력
        
        // 피보나치 출력 횟수를 미리 계산
        for (int i = 2; i <= 40; i++) {
            fibCounts[i][0] = fibCounts[i - 1][0] + fibCounts[i - 2][0];
            fibCounts[i][1] = fibCounts[i - 1][1] + fibCounts[i - 2][1];
        }
        
        // 테스트 케이스 개수 입력
        int T = Integer.parseInt(br.readLine());
        
        // 각 테스트 케이스에 대해 결과 출력
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(fibCounts[N][0] + " " + fibCounts[N][1]);
        }
    }
}
