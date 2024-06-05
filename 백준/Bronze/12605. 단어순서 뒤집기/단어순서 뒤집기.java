import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 행에서 케이스의 개수 N을 입력 받기
        int N = Integer.parseInt(br.readLine());

        // N개의 케이스에 대해 반복
        for (int i = 1; i <= N; i++) {
            // 각 케이스의 단어들을 읽기
            String line = br.readLine();

            // 단어들을 스페이스를 기준으로 분리하여 배열로 저장
            String[] words = line.split(" ");

            // 스택을 사용하여 단어들을 저장
            Stack<String> stack = new Stack<>();
            for (String word : words) {
                stack.push(word);
            }

            // 결과를 저장할 StringBuilder
            StringBuilder sb = new StringBuilder();
            sb.append("Case #").append(i).append(": ");

            // 스택에서 단어를 하나씩 꺼내어 반대 순서로 출력
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
                if (!stack.isEmpty()) {
                    sb.append(" ");
                }
            }

            // 결과 출력
            System.out.println(sb.toString());
        }
    }
}
