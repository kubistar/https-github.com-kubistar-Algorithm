import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄에서 봉우리의 수를 입력받음
        int n = Integer.parseInt(br.readLine());
        
        // 두 번째 줄에서 각 봉우리의 높이를 입력받아 배열에 저장
        int[] heights = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }
        
        // 최대 처치 가능한 적의 수를 저장할 변수
        int maxEnemies = 0;
        // 현재까지의 최대 높이를 저장할 변수 (첫 번째 봉우리의 높이로 초기화)
        int currentMaxHeight = heights[0];
        // 현재까지 쌓인 처치 가능한 적의 수를 저장할 변수
        int currentEnemies = 0;
        
        // 두 번째 봉우리부터 마지막 봉우리까지 순회하며 최대 처치 가능한 적의 수 계산
        for (int i = 1; i < n; i++) {
            // 현재 봉우리의 높이가 현재까지의 최대 높이보다 작으면
            if (heights[i] < currentMaxHeight) {
                // 처치 가능한 적의 수를 증가시킴
                currentEnemies++;
            } else {
                // 현재 봉우리의 높이가 현재까지의 최대 높이보다 크거나 같으면
                // 최대 처치 가능한 적의 수를 업데이트하고, 현재까지의 적 수를 초기화
                maxEnemies = Math.max(maxEnemies, currentEnemies);
                currentEnemies = 0;
                currentMaxHeight = heights[i]; // 현재까지의 최대 높이 업데이트
            }
        }
        
        // 마지막 봉우리까지 비교를 마치고 남은 적 수를 최종 비교하여 업데이트
        maxEnemies = Math.max(maxEnemies, currentEnemies);
        
        // 최대 처치 가능한 적의 수를 출력
        System.out.println(maxEnemies);
    }
}
