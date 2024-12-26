/*
입력
첫째 줄에 테스트 케이스의 개수 t가 주어진다. (t ≤ 50)

각 테스트 케이스의 첫째 줄에는 맥주를 파는 편의점의 개수 n이 주어진다. (0 ≤ n ≤ 100).

다음 n+2개 줄에는 상근이네 집, 편의점, 펜타포트 락 페스티벌 좌표가 주어진다. 
각 좌표는 두 정수 x와 y로 이루어져 있다. (두 값 모두 미터, -32768 ≤ x, y ≤ 32767)

송도는 직사각형 모양으로 생긴 도시이다. 
두 좌표 사이의 거리는 x 좌표의 차이 + y 좌표의 차이 이다. (맨해튼 거리)

출력
상근이네 집에서 페스티벌 장소까지, 또는 편의점을 거쳐 
페스티벌 장소까지 이동 가능한 경로를 찾을 수 있으면 "happy"
상근이네 집에서 페스티벌 장소까지 도달할 수 있는 경로가 존재하지 않으면 "sad"

*/

import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine()); // 편의점 수
            Node[] nodes = new Node[n + 2]; // 집 + 편의점 + 페스티벌
            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                nodes[i] = new Node(x, y);
            }

            // 그래프 연결
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n + 2; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < n + 2; i++) {
                for (int j = 0; j < n + 2; j++) {
                    if (i != j && manhattanDistance(nodes[i], nodes[j]) <= 1000) {
                        graph.get(i).add(j);
                    }
                }
            }

            // BFS 탐색
            if (bfs(graph, n + 2)) {
                sb.append("happy\n");
            } else {
                sb.append("sad\n");
            }
        }

        System.out.println(sb.toString());
    }

    // 맨해튼 거리 계산
    static int manhattanDistance(Node a, Node b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    // BFS 탐색
    static boolean bfs(List<List<Integer>> graph, int nodeCount) {
        boolean[] visited = new boolean[nodeCount];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0); // 시작점 (집)
        visited[0] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == nodeCount - 1) { // 페스티벌에 도달
                return true;
            }

            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        return false; // 페스티벌에 도달하지 못함
    }
}
