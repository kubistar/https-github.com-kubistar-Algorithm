import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int result = -1;  // 결과를 저장할 변수, 기본값은 -1로 설정 (설탕을 정확하게 배달할 수 없는 경우)

        for (int i = N / 5; i >= 0; i--) {
            int remainder = N - (i * 5);
            if (remainder % 3 == 0) {
                result = i + (remainder / 3);
                break;
            }
        }

        System.out.println(result);
    }
}
