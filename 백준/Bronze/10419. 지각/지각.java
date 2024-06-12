import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 줄에서 테스트 케이스의 수를 읽습니다.
        int T = Integer.parseInt(reader.readLine());
        int[] results = new int[T];
        
        // 각 테스트 케이스에 대해 최대 지각 시간을 계산합니다.
        for (int i = 0; i < T; i++) {
            int d = Integer.parseInt(reader.readLine());
            results[i] = findMaxLateTime(d);
        }
        
        // 결과를 출력합니다.
        for (int result : results) {
            System.out.println(result);
        }
    }
    
    // 수업 시간 d에 대해 교수님이 지각할 수 있는 최대 시간을 찾는 함수
    private static int findMaxLateTime(int d) {
        int t = 0;
        
        // t + t^2 <= d를 만족하는 최대 t를 찾습니다.
        while ((t + 1) + (t + 1) * (t + 1) <= d) {
            t++;
        }
        
        return t;
    }
}
