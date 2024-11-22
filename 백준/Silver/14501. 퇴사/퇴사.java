import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int N = Integer.parseInt(br.readLine()); // 일 수
        int[] T = new int[N + 1]; // 상담 소요 시간
        int[] P = new int[N + 1]; // 상담 금액
        int[] dp = new int[N + 2]; // DP 배열 (최대 수익 저장)

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // DP 테이블 채우기
        for (int i = N; i >= 1; i--) {
            if (i + T[i] <= N + 1) { // 상담이 가능한 경우
                dp[i] = Math.max(dp[i + 1], P[i] + dp[i + T[i]]);
            } else { // 상담이 불가능한 경우
                dp[i] = dp[i + 1];
            }
        }

        // 상담 일정 추적
        List<Integer> schedule = new ArrayList<>();
        int i = 1;
        while (i <= N) {
            if (i + T[i] <= N + 1 && dp[i] == P[i] + dp[i + T[i]]) {
                schedule.add(i); // 상담한 날 추가
                i += T[i]; // 상담이 끝난 날로 이동
            } else {
                i++; // 다음 날로 이동
            }
        }

        // 결과 출력
        System.out.println(dp[1]);
       
    }
}
