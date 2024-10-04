/*
N×M크기의 배열로 표현되는 미로가 있다.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1
미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 
이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 
프로그램을 작성하시오. 
한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

입력
첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 
다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.

출력
첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

최소칸수 ->  최단 경로
bfs
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 상, 하, 좌, 우로 이동하기 위한 방향 벡터 정의
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // BFS 탐색 함수
    public static int bfs(int[][] maze, int N, int M) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});  // 시작점 (0, 0) 삽입

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 4방향으로 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 미로 범위 안에 있고, 이동할 수 있는 1인 칸일 때만 이동
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && maze[nx][ny] == 1) {
                    // 이동할 수 있으므로, 현재 칸의 거리 + 1을 다음 칸에 기록
                    maze[nx][ny] = maze[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        // 도착 위치(N-1, M-1)의 값이 최단 거리
        return maze[N-1][M-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 N, M 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 미로 배열 입력
        int[][] maze = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        // BFS를 사용하여 최단 거리 출력
        System.out.println(bfs(maze, N, M));
    }
}
