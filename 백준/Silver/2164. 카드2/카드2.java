import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력을 받아 N에 저장
        int N = Integer.parseInt(br.readLine());
        
        // 큐 생성 및 초기화
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        
        // 큐가 한 장의 카드만 남을 때까지 반복
        while (queue.size() > 1) {
            // 제일 위의 카드를 버림
            queue.poll();
            // 제일 위의 카드를 꺼내서 가장 아래로 옮김
            queue.add(queue.poll());
        }
        
        // 마지막으로 남은 카드 출력
        System.out.println(queue.poll());
    }
}
