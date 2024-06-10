import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] order;
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
        
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        
        visited = new boolean[N + 1];
        order = new int[N + 1];
        
        dfs(R);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(order[i]).append("\n");
        }
        System.out.print(sb.toString());
    }
    
    public static void dfs(int node) {
        visited[node] = true;
        order[node] = counter++;
        
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}
