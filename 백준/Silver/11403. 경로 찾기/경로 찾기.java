/*
가중치 없는 방향 그래프 G가 주어졌을 때, 
모든 정점 (i, j)에 대해서, i에서 j로 가는 길이가 양수인 경로가 있는지 없는지 구하는 프로그램

입력
첫째 줄에 정점의 개수 N (1 ≤ N ≤ 100)이 주어진다. 
둘째 줄부터 N개 줄에는 그래프의 인접 행렬이 주어진다. 
i번째 줄의 j번째 숫자가 1인 경우에는 i에서 j로 가는 간선이 존재한다는 뜻이고, 0인 경우는 없다는 뜻이다. 
i번째 줄의 i번째 숫자는 항상 0이다.

출력
총 N개의 줄에 걸쳐서 문제의 정답을 인접행렬 형식으로 출력한다. 
정점 i에서 j로 가는 길이가 양수인 경로가 있으면 i번째 줄의 j번째 숫자를 1로, 없으면 0으로 출력해야 한다.

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    
    static int N; // 정점의 개수
    static int[][] graph; // 인접 행렬
    static boolean[] visited; // 방문 여부 체크 배열

    // DFS로 경로 탐색
    public static void dfs(int start, int current) {
        for (int next = 0; next < N; next++) {
            // 현재 정점에서 다음 정점으로 갈 수 있고, 방문한 적이 없다면
            if (graph[current][next] == 1 && !visited[next]) {
                visited[next] = true; // 방문 처리
                graph[start][next] = 1; // 경로가 있음을 표시
                dfs(start, next); // 다음 정점으로 재귀 호출
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력을 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄에서 정점의 개수 N 입력받기
        N = Integer.parseInt(br.readLine());
        
        // N x N 인접 행렬 생성
        graph = new int[N][N];
        
        // 인접 행렬 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 각 정점에서 DFS로 경로 탐색
        for (int i = 0; i < N; i++) {
            visited = new boolean[N]; // 방문 여부 배열 초기화
            dfs(i, i); // i에서 시작하는 경로 탐색
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
        // 최종 결과 출력
        System.out.print(sb.toString());
    }
}
