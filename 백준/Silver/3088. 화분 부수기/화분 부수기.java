import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(br.readLine());
        boolean[] chk = new boolean[1000001]; // 특정 숫자가 이미 처리되었는지 확인하기 위한 배열
        int cnt = 0;

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            // x, y, z 중 어느 숫자도 처리되지 않았다면
            if (!chk[x] && !chk[y] && !chk[z]) {
                cnt++; // 태완이가 직접 깨야 하는 화분 수 증가
            }

            // x, y, z 숫자를 처리된 상태로 표시
            chk[x] = true;
            chk[y] = true;
            chk[z] = true;
        }

        pw.println(cnt); // 직접 깨야 하는 최소 화분 개수 출력
        pw.flush();
    }
}
