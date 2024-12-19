/*
입력
첫 번째 줄은 테스트 케이스의 수를 나타나는 T를 입력받는다.

이후 각 테스트 케이스의 첫 번째 줄에서는 H,W 를 입력받는다. 
H는 그리드의 높이이고, W는 그리드의 너비이다. 
이후 그리드의 높이 H 에 걸쳐서 W개의 문자로 이루어진 문자열 하나를 입력받는다. 

0 < T ≤ 100
0 < H, W ≤ 100
출력
각 테스트 케이스마다, 양의 몇 개의 무리로 이루어져 있었는지를 한 줄에 출력하면 된다. 

*/

import java.io.*;
import java.util.*;

public class Main {
    static int H, W;
    static char[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        
        StringBuilder sb = new StringBuilder();
        
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            
            grid = new char[H][W];
            visited = new boolean[H][W];
            
            for (int i = 0; i < H; i++) {
                grid[i] = br.readLine().toCharArray();
            }
            
            int sheepGroups = 0; // 양 무리의 수
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (grid[i][j] == '#' && !visited[i][j]) {
                        bfs(i, j); // 하나의 무리를 탐색
                        sheepGroups++;
                    }
                }
            }
            sb.append(sheepGroups).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            
            for (int i = 0; i < 4; i++) { // 4방향 탐색
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx >= 0 && nx < H && ny >= 0 && ny < W && grid[nx][ny] == '#' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
