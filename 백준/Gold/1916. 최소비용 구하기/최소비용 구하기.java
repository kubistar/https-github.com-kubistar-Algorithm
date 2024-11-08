/*
N개의 도시가 있다. 
그리고 한 도시에서 출발하여 다른 도시에 도착하는 M개의 버스가 있다. 

입력
첫째 줄에 도시의 개수 N(1 ≤ N ≤ 1,000)
둘째 줄에는 버스의 개수 M(1 ≤ M ≤ 100,000)이 주어진다. 
그리고 셋째 줄부터 M+2줄까지 다음과 같은 버스의 정보가 주어진다. 
먼저 처음에는 그 버스의 출발 도시의 번호가 주어진다. 
그리고 그 다음에는 도착지의 도시 번호가 주어지고 또 그 버스 비용이 주어진다.
버스 비용은 0보다 크거나 같고, 100,000보다 작은 정수이다.

그리고 M+3째 줄에는 우리가 구하고자 하는 구간 출발점의 도시번호와 도착점의 도시번호가 주어진다. 
출발점에서 도착점을 갈 수 있는 경우만 입력으로 주어진다.

출력
첫째 줄에 출발 도시에서 도착 도시까지 가는데 드는 최소 비용을 출력

버스 정보:
1 -> 2 비용 2
1 -> 3 비용 3
1 -> 4 비용 1
1 -> 5 비용 10
2 -> 4 비용 2
3 -> 4 비용 1
3 -> 5 비용 1
4 -> 5 비용 3


가중치가 서로 다름-> 다익스트라 
*/

import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Node>> graph;
    static int[] distances;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄: 도시의 개수
        int n = Integer.parseInt(br.readLine());
        
        // 두 번째 줄: 버스의 개수
        int m = Integer.parseInt(br.readLine());
        
        // 그래프 초기화
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 거리 배열 초기화
        distances = new int[n + 1];
        Arrays.fill(distances, INF);
        
        // 그래프 구성 (간선 정보 입력 받기)
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());  // 출발 도시
            int v = Integer.parseInt(st.nextToken());  // 도착 도시
            int w = Integer.parseInt(st.nextToken());  // 비용
            graph.get(u).add(new Node(v, w));
        }
        
        // 출발점과 도착점 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        // 다익스트라 알고리즘 실행
        dijkstra(start);
        
        // 시작점에서 도착점까지의 최단 거리 출력 
        System.out.println(distances[end]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distances[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentNode = current.index;
            int currentDistance = current.distance;

            // 이미 처리된 노드라면 무시
            if (currentDistance > distances[currentNode]) {
                continue;
            }

            // 현재 노드의 인접 노드 탐색
            for (Node neighbor : graph.get(currentNode)) {
                int distance = currentDistance + neighbor.distance;

                // 더 짧은 경로를 발견했을 때 갱신
                if (distance < distances[neighbor.index]) {
                    distances[neighbor.index] = distance;
                    pq.offer(new Node(neighbor.index, distance));
                }
            }
        }
    }
}

// Node 클래스 (노드 정보를 담기 위한 클래스)
class Node implements Comparable<Node> {
    int index;  // 도착 도시
    int distance;  // 해당 도시까지의 비용

    Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    // 거리 기준으로 정렬 (오름차순)
    @Override
    public int compareTo(Node other) {
        return this.distance - other.distance;
    }
}