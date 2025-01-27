import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);  // 카드 수
        int M = Integer.parseInt(input[1]);  // 카드 합체를 몇 번 하는지를 나타내는 수

        PriorityQueue<Long> pq = new PriorityQueue<>();
        String[] cards = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            pq.add(Long.parseLong(cards[i]));
        }

        for (int i = 0; i < M; i++) {
            long x = pq.poll();
            long y = pq.poll();
            long sum = x + y;
            pq.add(sum);
            pq.add(sum);
        }

        long result = 0;
        while (!pq.isEmpty()) {
            result += pq.poll();
        }

        System.out.println(result);
    }
}