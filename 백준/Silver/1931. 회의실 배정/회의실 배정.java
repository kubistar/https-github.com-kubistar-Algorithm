import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] meetings = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            meetings[i][1] = Integer.parseInt(st.nextToken()); // 끝나는 시간
        }
        
        // 끝나는 시간 기준 오름차순 정렬, 끝나는 시간이 같으면 시작 시간 기준 오름차순 정렬
        Arrays.sort(meetings, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        
        int count = 0;
        int endTime = 0;
        
        // 회의 선택
        for (int i = 0; i < N; i++) {
            if (meetings[i][0] >= endTime) { // 이전 회의가 끝난 후 회의 시작 가능
                endTime = meetings[i][1];   // 끝나는 시간을 업데이트
                count++;                    // 회의 수 증가
            }
        }
        
        System.out.println(count);
    }
}
