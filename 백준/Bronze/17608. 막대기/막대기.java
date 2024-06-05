import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 막대기의 개수 N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 각 막대기의 높이를 담을 스택 선언
        Stack<Integer> stack = new Stack<>();

        // 높이 입력 받기
        for (int i = 0; i < N; i++) {
            stack.push(Integer.parseInt(br.readLine()));
        }

        // 현재까지 본 가장 높은 막대기의 높이
        int maxHeight = 0;
        // 보이는 막대기의 개수
        int count = 0;

        // 스택을 사용하여 오른쪽에서 왼쪽으로 탐색
        while (!stack.isEmpty()) {
            int height = stack.pop();
            if (height > maxHeight) {
                count++;
                maxHeight = height;
            }
        }

        // 결과 출력
        System.out.println(count);
    }
}
