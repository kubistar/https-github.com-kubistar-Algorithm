import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 색상의 수
        
        int[] jewels = new int[M];
        for (int i = 0; i < M; i++) {
            jewels[i] = Integer.parseInt(br.readLine());
        }
        
        // 이분 탐색 범위 설정
        int low = 1; // 최소 질투심
        int high = Arrays.stream(jewels).max().getAsInt(); // 보석 중 최대 개수
        int result = high;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (isValid(mid, jewels, N)) {
                result = mid; // 더 작은 질투심 탐색
                high = mid - 1;
            } else {
                low = mid + 1; // 더 큰 질투심 탐색
            }
        }
        
        System.out.println(result);
    }
    
    
    public static boolean isValid(int maxJealousy, int[] jewels, int students) {
        long requiredStudents = 0;
        
        for (int jewel : jewels) {
            // 보석 개수를 maxJealousy로 나눠 필요한 학생 수 계산
            requiredStudents += (jewel + maxJealousy - 1) / maxJealousy; 
            if (requiredStudents > students) {
                return false; // 필요한 학생 수가 N을 초과하면 불가능
            }
        }
        
        return true;
    }
}
