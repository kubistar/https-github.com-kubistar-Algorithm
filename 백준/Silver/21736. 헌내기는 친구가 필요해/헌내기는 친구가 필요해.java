import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] campus;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동
    static int[] dy = {0, 0, -1, 1}; // 상하좌우 이동
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        campus = new char[N][M];
        visited = new boolean[N][M];
        
        int startX = 0, startY = 0;
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = line.charAt(j);
                if (campus[i][j] == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }
        
        int result = bfs(startX, startY);
        
        if (result == 0) {
            System.out.println("TT");
        } else {
            System.out.println(result);
        }
    }
    
    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        
        int peopleCount = 0;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];
            
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !visited[nextX][nextY]) {
                    if (campus[nextX][nextY] != 'X') {
                        visited[nextX][nextY] = true;
                        queue.offer(new int[] {nextX, nextY});
                        if (campus[nextX][nextY] == 'P') {
                            peopleCount++;
                        }
                    }
                }
            }
        }
        
        return peopleCount;
    }
}
