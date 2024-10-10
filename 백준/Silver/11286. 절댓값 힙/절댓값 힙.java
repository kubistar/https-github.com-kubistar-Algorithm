/*
입력
첫째 줄에 연산의 개수 N(1≤N≤100,000)이 주어진다. 
다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다. 
만약 x가 0이 아니라면 배열에 x라는 값을 넣는(추가하는) 연산이고, 
x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다. 
입력되는 정수는 -231보다 크고, 231보다 작다.

출력
입력에서 0이 주어진 회수만큼 답을 출력한다. 
만약 배열이 비어 있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다.


배열에 값을 넣는다 (x ≠ 0).
0이 주어지면 배열에서 절댓값이 가장 작은 값을 출력하고 제거한다.
절댓값이 같으면 원래 값이 작은 것을 우선 출력한다.
배열이 비어 있으면 0을 출력한다.
*/

import java.io.*;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 연산의 개수 N을 입력
        int N = Integer.parseInt(br.readLine());

        // 우선순위 큐 (절댓값 기준으로 정렬, 절댓값이 같으면 원래 숫자가 작은 순서로)
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int abs1 = Math.abs(o1);
                int abs2 = Math.abs(o2);
                if (abs1 == abs2) {
                    return o1 - o2; // 절댓값이 같으면 원래 숫자 비교
                }
                return abs1 - abs2; // 절댓값 기준 비교
            }
        });

        // N개의 연산 처리
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                // 절댓값이 가장 작은 값을 출력하고 제거
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                // x를 우선순위 큐에 추가
                pq.offer(x);
            }
        }

        // 결과 출력
        System.out.print(sb.toString());
    }
}
