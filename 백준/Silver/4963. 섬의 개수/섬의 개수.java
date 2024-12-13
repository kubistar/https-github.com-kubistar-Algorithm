/*
입력
입력은 여러 개의 테스트 케이스로 이루어져 있다. 
각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다. 
w와 h는 50보다 작거나 같은 양의 정수이다.

둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.

입력의 마지막 줄에는 0이 두 개 주어진다.

출력
각 테스트 케이스에 대해서, 섬의 개수를 출력한다.

0: 바다
1: 땅
서로 연결된 땅(가로, 세로, 대각선)을 한 섬으로 간주.

*/

import java.io.*;
import java.util.*;

public class Main {
    static int w, h;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}; // 8방향: 대각선, 상하좌우
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            
            if (w == 0 && h == 0) break; // 종료 조건
            
            map = new int[h][w];
            visited = new boolean[h][w];
            
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j); // 하나의 섬을 탐색
                        count++; // 섬 개수 증가
                    }
                }
            }
            
            sb.append(count).append("\n"); // 결과 저장
        }
        
        System.out.print(sb); // 결과 출력
    }
    
    static void dfs(int x, int y) {
        visited[x][y] = true;
        
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny); // 재귀적으로 탐색
                }
            }
        }
    }
}
