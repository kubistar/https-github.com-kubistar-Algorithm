import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int findFastestTime(int N, int K) {
        // 최대 위치 설정
        int maxPosition = 100000;
        // 방문 여부를 체크하기 위한 배열
        boolean[] visited = new boolean[maxPosition + 1];
        
        // BFS를 위한 큐 설정
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{N, 0}); // (현재 위치, 현재 시간)
        visited[N] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentPosition = current[0];
            int currentTime = current[1];
            
            // 동생을 찾았을 경우 현재 시간을 반환
            if (currentPosition == K) {
                return currentTime;
            }
            
            // 다음 가능한 이동을 탐색
            int[] nextPositions = {currentPosition - 1, currentPosition + 1, currentPosition * 2};
            
            for (int nextPosition : nextPositions) {
                if (nextPosition >= 0 && nextPosition <= maxPosition && !visited[nextPosition]) {
                    visited[nextPosition] = true;
                    queue.offer(new int[]{nextPosition, currentTime + 1});
                }
            }
        }
        
        // 이 줄은 절대 실행되지 않지만, Java 메서드는 반드시 값을 반환해야 하므로 추가합니다.
        return -1;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 입력
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        
        // 결과 출력
        System.out.println(findFastestTime(N, K));
    }
}
