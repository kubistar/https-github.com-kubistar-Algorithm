import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // N: 1부터 N까지의 자연수
        int M = Integer.parseInt(st.nextToken());  // M: 고를 숫자의 개수

        // 결과를 저장할 배열
        int[] result = new int[M];
        StringBuilder sb = new StringBuilder();  // 출력에 사용할 StringBuilder
        // 백트래킹 시작
        backtrack(1, 0, N, M, result, sb);
        System.out.print(sb);  // 모든 결과를 한 번에 출력
    }

    // 백트래킹 함수
    public static void backtrack(int start, int depth, int N, int M, int[] result, StringBuilder sb) {
        // M개의 숫자를 모두 선택한 경우 출력
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // start부터 N까지 숫자를 선택
        for (int i = start; i <= N; i++) {
            result[depth] = i;
            backtrack(i + 1, depth + 1, N, M, result, sb);
        }
    }
}
