import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        // 1부터 N까지의 숫자를 큐에 삽입
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        
        // 큐에 카드가 한 장 남을 때까지 반복
        while (queue.size() > 1) {
            sb.append(queue.poll()).append(" ");  // 맨 위 카드를 버림
            queue.add(queue.poll());              // 그다음 맨 위 카드를 뒤로 옮김
        }

        // 마지막 남은 카드 추가
        sb.append(queue.poll());
        
        System.out.println(sb.toString());
    }
}
