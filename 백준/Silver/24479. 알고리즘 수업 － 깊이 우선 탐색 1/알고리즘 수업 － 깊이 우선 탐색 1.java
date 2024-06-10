import java.io.*;
import java.util.*;

public class Main {
    // 그래프를 저장할 인접 리스트 배열
    static List<Integer>[] graph;
    // 방문 여부를 저장할 배열
    static boolean[] visited;
    // 각 정점의 방문 순서를 저장할 배열
    static int[] order;
    // 방문 순서를 위한 카운터
    static int counter = 1;
    
    public static void main(String[] args) throws IOException {
        // 입력을 읽기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫 번째 줄의 입력을 공백을 기준으로 분리하여 배열에 저장
        String[] firstLine = br.readLine().split(" ");
        
        // 정점의 수, 간선의 수, 시작 정점 번호를 변수에 저장
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        int R = Integer.parseInt(firstLine[2]);
        
        // 그래프 초기화 (정점 번호가 1부터 시작하므로 N+1 크기로 생성)
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 간선 정보를 읽어와서 그래프에 추가
        for (int i = 0; i < M; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            graph[u].add(v);
            graph[v].add(u);
        }
        
        // 각 정점의 인접 리스트를 오름차순으로 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        
        // 방문 여부와 방문 순서 배열 초기화
        visited = new boolean[N + 1];
        order = new int[N + 1];
        
        // DFS를 시작 정점 R에서 시작
        dfs(R);
        
        // 각 정점의 방문 순서를 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(order[i]).append("\n");
        }
        System.out.print(sb.toString());
    }
    
    // DFS 함수
    public static void dfs(int node) {
        // 현재 노드를 방문 처리
        visited[node] = true;
        // 현재 노드의 방문 순서를 기록
        order[node] = counter++;
        
        // 현재 노드의 인접 정점을 순회
        for (int neighbor : graph[node]) {
            // 인접 정점이 아직 방문되지 않았다면 재귀적으로 DFS 호출
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}
