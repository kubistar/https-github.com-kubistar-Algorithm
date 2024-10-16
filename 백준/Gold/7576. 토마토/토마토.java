import java.io.*;
import java.util.*;

public class Main {
    // 4방향 탐색을 위한 배열
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        // BufferedReader로 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 가로 크기
        int N = Integer.parseInt(st.nextToken()); // 세로 크기

        int[][] box = new int[N][M]; // 창고 
        Queue<int[]> queue = new LinkedList<>(); // BFS 탐색을 위한 큐
        int totalUnripe = 0; // 익지 않은 토마토의 개수
        int totalRipe = 0; // 익은 토마토의 개수

        // 격자의 각 위치 상태 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    // 익은 토마토는 큐에 넣기
                    queue.offer(new int[]{i, j});
                    totalRipe++;
                } else if (box[i][j] == 0) {
                    // 익지 않은 토마토 개수 카운트
                    totalUnripe++;
                }
            }
        }
        
        
        // 만약 저장될 때부터 모든 토마토가 익어있다면 0을 출력하고 종료
        if (totalUnripe == 0) {
            System.out.println(0);
            return;
        }

        int days = 0; // 날짜 카운트 변수

        // BFS 시작
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                // 상하좌우 네 방향 탐색
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    // 범위 내에 있고, 아직 익지 않은 토마토(0)인 경우
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && box[nx][ny] == 0) {
                        // 토마토가 익음
                        box[nx][ny] = 1;
                        queue.offer(new int[]{nx, ny});
                        totalUnripe--; // 익지 않은 토마토가 하나 줄어듦
                    }
                }
            }
            // 하루가 지남
            days++;
        }

        // 익지 않은 토마토가 남아 있으면 -1 출력
        if (totalUnripe > 0) {
            System.out.println(-1);
        } else {
            // 마지막 날은 제외하고 출력
            System.out.println(days - 1);
        }
    }
}