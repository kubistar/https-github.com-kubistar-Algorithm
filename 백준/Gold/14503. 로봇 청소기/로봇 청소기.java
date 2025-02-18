import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] room;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dy = {0, 1, 0, -1};

    public static int cleanRoom(int r, int c, int d) {
        int count = 0;

        while (true) {
            // 현재 칸 청소
            if (!visited[r][c]) {
                visited[r][c] = true;
                count++;
            }

            // 주변 4칸 확인
            boolean found = false;
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4; // 반시계 방향 회전
                int nx = r + dx[d];
                int ny = c + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && room[nx][ny] == 0 && !visited[nx][ny]) {
                    r = nx;
                    c = ny;
                    found = true;
                    break;
                }
            }

            // 청소할 곳이 없으면 후진
            if (!found) {
                int backD = (d + 2) % 4;
                int br = r + dx[backD];
                int bc = c + dy[backD];

                if (room[br][bc] == 1) { // 벽이면 종료
                    return count;
                }
                // 후진 가능하면 후진
                r = br;
                c = bc;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 방 크기 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 초기 위치 및 방향 입력
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        // 방 정보 입력
        room = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 결과 출력
        System.out.println(cleanRoom(r, c, d));
    }
}
