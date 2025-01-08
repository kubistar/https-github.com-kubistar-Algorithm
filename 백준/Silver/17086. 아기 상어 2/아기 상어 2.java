/*
입력
첫째 줄에 공간의 크기 N과 M(2 ≤ N, M ≤ 50)이 주어진다. 
둘째 줄부터 N개의 줄에 공간의 상태가 주어지며, 0은 빈 칸, 1은 아기 상어가 있는 칸이다. 
빈 칸과 상어의 수가 각각 한 개 이상인 입력만 주어진다.

출력
첫째 줄에 안전 거리의 최댓값을 출력한다.
bfs
*/

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};  // 8방향 이동
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    dist[i][j] = 0;  // 상어가 있는 칸의 거리는 0으로 설정
                } else {
                    dist[i][j] = -1;  // 빈 칸은 -1로 초기화
                }
            }
        }

        bfs(queue);

        int maxDistance = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maxDistance = Math.max(maxDistance, dist[i][j]);
            }
        }

        System.out.println(maxDistance);
    }

    static void bfs(Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
