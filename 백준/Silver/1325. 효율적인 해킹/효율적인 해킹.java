/*
입력
첫째 줄에, N과 M이 들어온다.
N은 10,000보다 작거나 같은 자연수, M은 100,000보다 작거나 같은 자연수이다. 
둘째 줄부터 M개의 줄에 신뢰하는 관계가 A B와 같은 형식으로 들어오며, "A가 B를 신뢰한다"를 의미한다. 
컴퓨터는 1번부터 N번까지 번호가 하나씩 매겨져 있다.

출력
첫째 줄에, 김지민이 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 오름차순으로 출력한다.

A가 B를 신뢰한다 ->  B를 해킹하면 A도 해킹된다
각 컴퓨터를 시작 노드로 했을 때, 몇 개의 컴퓨터를 해킹할 수 있는지 계산
*/

import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] reverseGraph;
    static int[] hackCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        reverseGraph = new ArrayList[n + 1];
        hackCount = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            reverseGraph[b].add(a); // 역방향 그래프 구성
        }

        for (int i = 1; i <= n; i++) {
            bfs(i);
        }

        int maxCount = Arrays.stream(hackCount).max().getAsInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (hackCount[i] == maxCount) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }

    static void bfs(int start) {
        boolean[] visited = new boolean[reverseGraph.length];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : reverseGraph[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    hackCount[start]++;
                    queue.offer(next);
                }
            }
        }
    }
}

