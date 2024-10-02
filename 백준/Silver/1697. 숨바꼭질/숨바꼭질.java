/*

입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

출력
수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.

bfs

*/



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static int bfs(int N, int K) {
        int maxLimit = 100001;
        int[] visited = new int[maxLimit]; // 방문 시간 저장 배열

        // 큐를 초기화하고 시작점 N을 넣음
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = 1; // 시작점을 방문했음을 표시 (시간을 1로 설정)

        while (!queue.isEmpty()) {
            int currentPosition = queue.poll();
            
            // 동생을 찾았을 경우
            if (currentPosition == K) {
                return visited[currentPosition] - 1; // 시작점을 1로 했으므로 결과에서 1을 뺌
            }

            // 다음으로 이동할 세 가지 위치를 탐색
            int[] nextPositions = {currentPosition - 1, currentPosition + 1, currentPosition * 2};
            for (int nextPosition : nextPositions) {
                if (nextPosition >= 0 && nextPosition < maxLimit && visited[nextPosition] == 0) {
                    queue.add(nextPosition);
                    visited[nextPosition] = visited[currentPosition] + 1; // 이전 위치에서 1초 추가
                }
            }
        }
        return -1; // 이 경우는 발생하지 않음
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        // BFS 탐색 결과 출력
        System.out.println(bfs(N, K));
    }
}
