/*
입력
첫째 줄에 게임판에 있는 사다리의 수 N(1 ≤ N ≤ 15)과 뱀의 수 M(1 ≤ M ≤ 15)이 주어진다.

둘째 줄부터 N개의 줄에는 사다리의 정보를 의미하는 x, y (x < y)가 주어진다. 
x번 칸에 도착하면, y번 칸으로 이동한다는 의미이다.

다음 M개의 줄에는 뱀의 정보를 의미하는 u, v (u > v)가 주어진다. 
u번 칸에 도착하면, v번 칸으로 이동한다는 의미이다.

1번 칸과 100번 칸은 뱀과 사다리의 시작 또는 끝이 아니다. 
모든 칸은 최대 하나의 사다리 또는 뱀을 가지고 있으며, 동시에 두 가지를 모두 가지고 있는 경우는 없다. 
항상 100번 칸에 도착할 수 있는 입력만 주어진다.

출력
100번 칸에 도착하기 위해 주사위를 최소 몇 번 굴려야 하는지 출력


bfs

*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 사다리의 수
        int M = Integer.parseInt(st.nextToken()); // 뱀의 수
        
        int[] board = new int[101]; // 1~100번 칸, 각 칸의 목적지 정보 저장 (사다리 또는 뱀에 의해 이동)
        for (int i = 1; i <= 100; i++) {
            board[i] = i; // 기본적으로는 이동할 목적지가 자기 자신
        }

        // 사다리 입력 처리
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y; // x번 칸에 사다리가 있어서 y번 칸으로 이동
        }

        // 뱀 입력 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            board[u] = v; // u번 칸에 뱀이 있어서 v번 칸으로 이동
        }

        // BFS를 사용하여 최소 주사위 횟수 찾기
        System.out.println(bfs(board));
    }

    // BFS 메서드
    public static int bfs(int[] board) {
        boolean[] visited = new boolean[101]; // 각 칸의 방문 여부 저장
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{1, 0}); // 시작점 (1번 칸에서 시작, 주사위 횟수 0)
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0]; // 현재 위치
            int rolls = current[1];    // 주사위를 굴린 횟수

            // 100번 칸에 도착했으면 종료
            if (position == 100) {
                return rolls;
            }

            // 주사위의 값은 1부터 6까지
            for (int dice = 1; dice <= 6; dice++) {
                int nextPos = position + dice;

                // 100번 칸을 넘어가면 이동 불가
                if (nextPos > 100) {
                    continue;
                }

                // 사다리나 뱀이 있으면 이동한 위치로 변경
                nextPos = board[nextPos];

                // 아직 방문하지 않은 칸이면 이동
                if (!visited[nextPos]) {
                    visited[nextPos] = true;
                    queue.offer(new int[]{nextPos, rolls + 1});
                }
            }
        }

        return -1; // 도달할 수 없는 경우는 없으므로 이 코드는 실행되지 않음
    }
}
