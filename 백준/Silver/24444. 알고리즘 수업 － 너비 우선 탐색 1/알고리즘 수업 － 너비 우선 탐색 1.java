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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        int R = Integer.parseInt(firstLine[2]);
        
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            graph[u].add(v);
            graph[v].add(u);
        }
        
        // 인접 리스트를 오름차순으로 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        
        visited = new boolean[N + 1];
        order = new int[N + 1];
        
        // BFS 수행
        bfs(R);
        
        // 각 정점의 방문 순서 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(order[i]).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        order[start] = counter++;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    order[neighbor] = counter++;
                    queue.add(neighbor);
                }
            }
        }
    }
}
