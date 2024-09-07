/*
입력
첫째 줄에는 컴퓨터의 수가 주어진다.(컴퓨터의 수: 1 ≤ 컴퓨터의 수 ≤ 100)
둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다. 
이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.

출력
1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력

그래프
*/


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 컴퓨터의 수
        int n = Integer.parseInt(br.readLine());
        
        // 네트워크 상에서 직접 연결된 컴퓨터 쌍의 수
        int m = Integer.parseInt(br.readLine());
        
        // 그래프(인접 리스트) 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 연결된 컴퓨터 쌍 입력 받기
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            
            // 양방향 그래프 생성 (a <-> b 연결)
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        // 방문한 컴퓨터를 추적할 배열
        boolean[] visited = new boolean[n + 1];
        
        // 1번 컴퓨터에서 출발하여 그래프 탐색
        int result = graphTraversal(1, graph, visited);
        
        // 1번 컴퓨터를 제외한 감염된 컴퓨터 수 출력
        System.out.println(result - 1);
    }

    // 그래프 탐색 메서드 
    public static int graphTraversal(int start, List<List<Integer>> graph, boolean[] visited) {
        // 탐색한 컴퓨터 수
        int count = 1;
        
        // 현재 컴퓨터 방문 처리
        visited[start] = true;
        
        // 현재 컴퓨터와 연결된 모든 컴퓨터 탐색
        for (int next : graph.get(start)) {
            if (!visited[next]) {
                count += graphTraversal(next, graph, visited);  // 재귀적으로 탐색
            }
        }
        
        return count;
    }
}
