import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map; // 빙산 높이 정보
    static boolean[][] visited; // 방문 여부 확인
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력 받기
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int years = 0;
        while (true) {
            // 덩어리 개수 계산
            int parts = countIcebergParts();
            if (parts >= 2) {
                System.out.println(years); // 빙산이 분리되는 최초의 시간 출력
                return;
            }

            // 빙산이 전부 녹았는지 확인
            if (isAllMelted()) {
                System.out.println(0); // 빙산이 다 녹을 때까지 분리되지 않음
                return;
            }

            // 빙산 녹이기
            meltIceberg();
            years++;
        }
    }

    // 빙산 덩어리 개수를 세는 함수
    static int countIcebergParts() {
        visited = new boolean[N][M];
        int parts = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    bfs(i, j); // 새로운 덩어리를 탐색
                    parts++; // 덩어리 개수 증가
                }
            }
        }

        return parts;
    }

    // BFS로 연결된 빙산을 탐색
    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            // 동서남북 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 배열 범위 확인 및 방문하지 않은 빙산인지 체크
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] > 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[] {nx, ny});
                    }
                }
            }
        }
    }

    // 빙산 녹이기
    static void meltIceberg() {
        int[][] temp = new int[N][M]; // 녹은 후 높이를 저장할 배열

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    int waterCount = 0;

                    // 동서남북 방향으로 바다(0)의 개수 계산
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0) {
                            waterCount++;
                        }
                    }

                    // 현재 칸의 높이에서 바다 개수만큼 감소
                    temp[i][j] = Math.max(0, map[i][j] - waterCount);
                }
            }
        }

        // 업데이트된 높이 정보를 기존 배열에 복사
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = temp[i][j];
            }
        }
    }

    // 빙산이 전부 녹았는지 확인
    static boolean isAllMelted() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
