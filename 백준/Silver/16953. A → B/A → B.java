/*
입력
첫째 줄에 A, B (1 ≤ A < B ≤ 109)가 주어진다.

출력
A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값을 출력한다. 만들 수 없는 경우에는 -1을 출력한다.
bfs

*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Node {
        long value;
        int count;

        Node(long value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long A = scanner.nextLong();
        long B = scanner.nextLong();

        int result = bfs(A, B);
        System.out.println(result);
    }

    private static int bfs(long A, long B) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(A, 1));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.value == B) {
                return current.count;
            }

            long nextValue1 = current.value * 2;
            long nextValue2 = current.value * 10 + 1;

            if (nextValue1 <= B) {
                queue.add(new Node(nextValue1, current.count + 1));
            }
            if (nextValue2 <= B) {
                queue.add(new Node(nextValue2, current.count + 1));
            }
        }

        return -1;
    }
}
