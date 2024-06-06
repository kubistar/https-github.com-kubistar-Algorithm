import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // BufferedReader를 사용하여 입력을 받기 위해 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder를 사용하여 출력을 효율적으로 처리
        StringBuilder sb = new StringBuilder();
        // PriorityQueue를 사용하여 최소 힙을 구현
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        try {
            // 첫 번째 줄에서 연산의 개수 N을 읽음
            int N = Integer.parseInt(br.readLine());
            
            // N개의 명령을 처리하기 위해 반복
            for (int i = 0; i < N; i++) {
                // 각 명령어를 한 줄씩 읽어서 정수 x로 변환
                int x = Integer.parseInt(br.readLine());

                // x가 0보다 크면 힙에 x를 추가
                if (x > 0) {
                    minHeap.offer(x);
                } else {
                    // x가 0이면 힙에서 최소값을 꺼내 출력
                    if (minHeap.isEmpty()) {
                        // 힙이 비어 있으면 0을 출력
                        sb.append(0).append('\n');
                    } else {
                        // 힙이 비어 있지 않으면 최소값을 꺼내어 출력
                        sb.append(minHeap.poll()).append('\n');
                    }
                }
            }
        } catch (IOException e) {
            // 입출력 예외가 발생할 경우 스택 트레이스를 출력하여 디버깅
            e.printStackTrace();
        }
        
        // 최종 결과를 한꺼번에 출력
        System.out.print(sb.toString());
    }
}
