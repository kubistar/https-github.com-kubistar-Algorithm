import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                minHeap.offer(num);
                if (minHeap.size() > N) {
                    minHeap.poll(); // 힙 크기를 N으로 유지
                }
            }
        }
        System.out.println(minHeap.peek()); // N번째 큰 수
    }
}
