import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 처리
        int N = Integer.parseInt(br.readLine().trim());
        int K = Integer.parseInt(br.readLine().trim());
        
        int[] sensors = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }
        
        // 센서 위치 정렬
        Arrays.sort(sensors);
        
        // 센서 간 거리 계산
        int[] distances = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            distances[i] = sensors[i + 1] - sensors[i];
        }
        
        // 거리 정렬
        Arrays.sort(distances);
        
        // 가장 긴 거리 K-1개 제거
        int result = 0;
        for (int i = 0; i < N - K; i++) {
            result += distances[i];
        }
        
        // 결과 출력
        System.out.println(result);
    }
}
