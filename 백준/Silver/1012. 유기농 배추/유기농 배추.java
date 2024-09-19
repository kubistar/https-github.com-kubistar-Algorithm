/*
입력
입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다. 
그 다음 줄부터 각각의 테스트 케이스에 대해 첫째 줄에는 배추를 심은 배추밭의 가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50), 
그리고 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)이 주어진다. 
그 다음 K줄에는 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)가 주어진다. 
두 배추의 위치가 같은 경우는 없다.

출력
각 테스트 케이스에 대해 필요한 최소의 배추흰지렁이 마리 수를 출력한다.

*/

import java.io.*;
import java.util.*;

public class Main {
    static int M, N, K;  // 배추밭의 가로, 세로 길이, 배추의 개수
    static int[][] field;  // 배추밭 배열
    static boolean[][] visited;  // 방문 여부 체크 배열
    static int[] dx = {0, 0, -1, 1};  // 상, 하, 좌, 우 이동 좌표
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 개수
        
        for (int t = 0; t < T; t++) {
            // 입력 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());  // 가로 길이
            N = Integer.parseInt(st.nextToken());  // 세로 길이
            K = Integer.parseInt(st.nextToken());  // 배추 개수
            
            // 배추밭과 방문 체크 배열 초기화
            field = new int[N][M];
            visited = new boolean[N][M];
            
            // 배추 위치 입력 받기
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[y][x] = 1;  // 배추가 심어진 곳을 1로 표시
            }
            
            // 필요한 배추흰지렁이 수 계산
            int wormCount = 0;
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    // 배추가 있고 아직 방문하지 않은 경우 DFS 실행
                    if (field[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        wormCount++;  // 새로운 배추 그룹을 찾으면 지렁이 한 마리 추가
                    }
                }
            }
            
            // 결과 출력
            System.out.println(wormCount);
        }
    }

    // DFS를 사용하여 인접한 배추들을 방문 처리
    static void dfs(int x, int y) {
        visited[x][y] = true;  // 현재 위치 방문 처리
        
        // 상하좌우로 인접한 배추 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            // 범위 안에 있고, 배추가 있으며, 아직 방문하지 않은 경우
            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (field[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);  // 인접한 배추로 이동
                }
            }
        }
    }
}
