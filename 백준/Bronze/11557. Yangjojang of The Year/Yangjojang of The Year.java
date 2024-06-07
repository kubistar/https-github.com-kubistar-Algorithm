import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader 사용하여 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 테스트 케이스 수 입력
        int T = Integer.parseInt(br.readLine().trim());
        
        // 각 테스트 케이스 처리
        for (int i = 0; i < T; i++) {
            // 학교 수 입력
            int N = Integer.parseInt(br.readLine().trim());
            
            // 최대 술 소비량과 해당 학교 이름 초기화
            int maxAlcohol = -1;
            String schoolWithMaxAlcohol = "";
            
            // 각 학교 정보 입력 및 처리
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                String schoolName = st.nextToken();
                int alcoholConsumption = Integer.parseInt(st.nextToken());
                
                // 현재 학교의 술 소비량이 최대값보다 큰지 확인
                if (alcoholConsumption > maxAlcohol) {
                    maxAlcohol = alcoholConsumption;
                    schoolWithMaxAlcohol = schoolName;
                }
            }
            
            // 현재 테스트 케이스에서 술 소비가 가장 많은 학교 이름 출력
            System.out.println(schoolWithMaxAlcohol);
        }
    }
}
