/*
입력
첫째 줄에 유저의 수 N (2 ≤ N ≤ 100)과 
친구 관계의 수 M (1 ≤ M ≤ 5,000)이 주어진다. 
둘째 줄부터 M개의 줄에는 친구 관계가 주어진다. 
친구 관계는 A와 B로 이루어져 있으며, A와 B가 친구라는 뜻이다. 
A와 B가 친구이면, B와 A도 친구이며, A와 B가 같은 경우는 없다. 
친구 관계는 중복되어 들어올 수도 있으며, 친구가 한 명도 없는 사람은 없다. 
또, 모든 사람은 친구 관계로 연결되어져 있다. 
사람의 번호는 1부터 N까지이며, 두 사람이 같은 번호를 갖는 경우는 없다.

출력
첫째 줄에 BOJ의 유저 중에서 케빈 베이컨의 수가 가장 작은 사람을 출력한다. 
그런 사람이 여러 명일 경우에는 번호가 가장 작은 사람을 출력한다.


각 사용자와 다른 모든 사용자까지의 최소 거리를 계산하고, 이 거리의 합이 가장 작은 사람을 찾는 문제
그래프의 모든 노드에서 다른 모든 노드까지의 최단 거리   ->  bfs

*/



import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사용자 수
        int M = Integer.parseInt(st.nextToken()); // 친구 관계 수

        // 인접 리스트로 그래프 초기화
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 친구 관계 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        // 케빈 베이컨 수를 찾을 변수 초기화
        int minKevinBacon = Integer.MAX_VALUE;
        int person = -1;

        // 각 사용자마다 BFS 수행
        for (int i = 1; i <= N; i++) {
            int kevinBaconNumber = bfs(i, graph, N);

            // 케빈 베이컨 수가 더 작은 사람을 찾을 경우 갱신
            if (kevinBaconNumber < minKevinBacon) {
                minKevinBacon = kevinBaconNumber;
                person = i;
            }
        }

        // 결과 출력
        System.out.println(person);
    }

    // BFS를 통해 start 노드로부터 다른 모든 노드까지의 최소 거리의 합을 구하는 함수
    public static int bfs(int start, ArrayList<Integer>[] graph, int N) {
        boolean[] visited = new boolean[N + 1]; // 방문 여부 확인용 배열
        int[] distance = new int[N + 1];        // 거리 저장 배열
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : graph[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[current] + 1;
                    queue.add(neighbor);
                }
            }
        }

        // 모든 노드에 대한 거리를 더한 값을 반환
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += distance[i];
        }
        return sum;
    }
}
