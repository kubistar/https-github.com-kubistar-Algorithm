/*
최대 힙을 이용하여 다음과 같은 연산을 지원하는 프로그램을 작성

배열에 자연수 x를 넣는다.
배열에서 가장 큰 값을 출력하고, 그 값을 배열에서 제거한다.
프로그램은 처음에 비어있는 배열에서 시작하게 된다.

입력
첫째 줄에 연산의 개수 N(1 ≤ N ≤ 100,000)이 주어진다. 
다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다. 
만약 x가 자연수라면 배열에 x라는 값을 넣는(추가하는) 연산이고, x가 0이라면 배열에서 가장 큰 값을 출력하고 
그 값을 배열에서 제거하는 경우이다. 입력되는 자연수는 231보다 작다.

출력
입력에서 0이 주어진 횟수만큼 답을 출력한다. 만약 배열이 비어 있는 경우인데 가장 큰 값을 출력하라고 한 경우에는 0을 출력
*/


import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); 
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x > 0) {
                maxHeap.offer(x); // 자연수를 추가
            } else {
                if (maxHeap.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(maxHeap.poll()).append("\n"); // 가장 큰 값 출력 및 제거
                }
            }
        }

        System.out.print(sb);
    }
}

