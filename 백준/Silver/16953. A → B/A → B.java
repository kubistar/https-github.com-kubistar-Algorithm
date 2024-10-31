/*
입력
첫째 줄에 A, B (1 ≤ A < B ≤ 109)가 주어진다.

출력
A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값을 출력한다. 만들 수 없는 경우에는 -1을 출력한다.
bfs

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    // Node 클래스는 BFS 탐색에서 사용되는 각 노드
    // 각 노드는 현재 값(value)과 그 값에 도달하기 위한 연산 횟수(count)를 저장
    static class Node {
        long value;
        int count;

        Node(long value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" "); 
        long A = Long.parseLong(input[0]); // 시작 값 A 
        long B = Long.parseLong(input[1]); // 목표 값 B 

        int result = bfs(A, B); // A를 B로 변환하는 데 필요한 최소 연산 횟수를 계산
        System.out.println(result); // 결과를 출력
    }

    // BFS
    private static int bfs(long A, long B) {
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(new Node(A, 1)); // 초기 상태인 A와 연산 횟수 1을 큐에 추가

        while (!queue.isEmpty()) {
            Node current = queue.poll(); // 큐에서 현재 노드를 꺼냄

            // 현재 값이 목표 값 B와 같다면 현재까지의 연산 횟수를 반환
            if (current.value == B) {
                return current.count;
            }

            // 두 가지 연산을 수행해 다음 가능한 값을 계산
            long nextValue1 = current.value * 2; // 첫 번째 연산: 현재 값에 2를 곱한다
            long nextValue2 = current.value * 10 + 1; // 두 번째 연산: 현재 값의 가장 오른쪽에 1을 추가.

            // 다음 값이 목표 값 B보다 작거나 같으면 큐에 추가
            if (nextValue1 <= B) {
                queue.add(new Node(nextValue1, current.count + 1));
            }
            if (nextValue2 <= B) {
                queue.add(new Node(nextValue2, current.count + 1));
            }
        }

        return -1; // 목표 값 B에 도달할 수 없는 경우 -1을 반환
    }
}
