import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫 번째 줄에서 선수의 수 N을 읽음
        int N = Integer.parseInt(br.readLine());

        int maxScore = 0; // 우승자의 최종 점수를 저장할 변수 초기화

        // N명의 선수에 대해 반복
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 두 번의 런 점수를 배열에 저장
            int run1 = Integer.parseInt(st.nextToken());
            int run2 = Integer.parseInt(st.nextToken());

            // 다섯 번의 트릭 점수를 배열에 저장
            int[] tricks = new int[5];
            for (int j = 0; j < 5; j++) {
                tricks[j] = Integer.parseInt(st.nextToken());
            }

            // 두 번의 런 점수 중 최고 점수를 찾음
            int bestRun = Math.max(run1, run2);

            // 다섯 번의 트릭 점수 중 상위 두 개의 점수를 찾기 위해 정렬
            Arrays.sort(tricks);
            int bestTrick1 = tricks[4]; // 가장 높은 점수
            int bestTrick2 = tricks[3]; // 두 번째로 높은 점수

            // 최종 점수를 계산
            int finalScore = bestRun + bestTrick1 + bestTrick2;

            // 최고 점수를 갱신
            if (finalScore > maxScore) {
                maxScore = finalScore;
            }
        }

        // 우승자의 최종 점수를 출력
        System.out.println(maxScore);

        // BufferedReader 닫기
        br.close();
    }
}
