import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            // 수첩 1 입력
            int N = Integer.parseInt(br.readLine());
            Set<Integer> note1 = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                note1.add(Integer.parseInt(st.nextToken()));
            }

            // 수첩 2 입력
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                int num = Integer.parseInt(st.nextToken());
                // 수첩 1에 있으면 1, 없으면 0 출력
                if (note1.contains(num)) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            }
        }

        System.out.print(sb);
    }
}
