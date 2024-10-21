import java.io.*;

import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 개수

        for (int t = 0; t < T; t++) {

            int k = Integer.parseInt(br.readLine());  // 연산의 개수

            PriorityQueue<Integer> minHeap = new PriorityQueue<>();  // 최솟값을 위한 최소 힙

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());  // 최댓값을 위한 최대 힙

            Map<Integer, Integer> countMap = new HashMap<>();  // 값의 유효성을 관리하기 위한 카운트 맵

            for (int i = 0; i < k; i++) {

                String[] input = br.readLine().split(" ");

                String command = input[0];

                int num = Integer.parseInt(input[1]);

                if (command.equals("I")) {  // 삽입 연산

                    minHeap.offer(num);

                    maxHeap.offer(num);

                    countMap.put(num, countMap.getOrDefault(num, 0) + 1);

                } else if (command.equals("D")) {  // 삭제 연산

                    if (!countMap.isEmpty()) {

                        if (num == 1) {  // 최댓값 삭제

                            removeElement(maxHeap, countMap);

                        } else {  // 최솟값 삭제

                            removeElement(minHeap, countMap);

                        }

                    }

                }

            }

            // 최종 큐에서 유효한 값만 남기고 최댓값과 최솟값을 확인

            cleanHeap(maxHeap, countMap);

            cleanHeap(minHeap, countMap);

            // 최종적으로 큐가 비었는지 확인

            if (countMap.isEmpty()) {

                System.out.println("EMPTY");

            } else {

                // 유효한 최댓값과 최솟값 출력

                System.out.println(maxHeap.peek() + " " + minHeap.peek());

            }

        }

    }

    // 우선순위 큐에서 유효하지 않은 값을 제거하는 함수

    private static void cleanHeap(PriorityQueue<Integer> heap, Map<Integer, Integer> countMap) {

        while (!heap.isEmpty() && countMap.getOrDefault(heap.peek(), 0) == 0) {

            heap.poll();  // 유효하지 않은 값 제거

        }

    }

    // 유효한 값 제거 함수 (최대/최소 값에 대해)

    private static void removeElement(PriorityQueue<Integer> heap, Map<Integer, Integer> countMap) {

        cleanHeap(heap, countMap);

        if (!heap.isEmpty()) {

            int value = heap.poll();

            countMap.put(value, countMap.get(value) - 1);

            if (countMap.get(value) == 0) {

                countMap.remove(value);  // 값이 0이 되면 맵에서 제거

            }

        }

    }

}

