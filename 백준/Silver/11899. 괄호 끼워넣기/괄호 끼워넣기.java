import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 괄호열 입력 받기
        String S = br.readLine();

        // 앞과 뒤에 추가해야 할 괄호의 최소 개수를 구하는 함수 호출
        int result = minBracketsToAdd(S);
        
        // 결과 출력
        System.out.println(result);

        // BufferedReader 닫기
        br.close();
    }

    // 괄호열을 올바른 괄호열로 만들기 위해 필요한 최소한의 괄호 개수를 계산하는 함수
    public static int minBracketsToAdd(String S) {
        Stack<Character> stack = new Stack<>();
        int openNeeded = 0; // 앞에 필요한 여는 괄호의 수
        
        // 문자열 S를 순회
        for (char ch : S.toCharArray()) {
            if (ch == '(') {
                // 여는 괄호는 스택에 추가
                stack.push(ch);
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    // 닫는 괄호가 있고 스택에 여는 괄호가 있으면 짝 맞추기
                    stack.pop();
                } else {
                    // 스택이 비어 있으면 앞에 여는 괄호가 필요함
                    openNeeded++;
                }
            }
        }

        // 스택에 남아 있는 여는 괄호의 수는 뒤에 필요한 닫는 괄호의 수
        int closeNeeded = stack.size();
        
        // 앞과 뒤에 필요한 괄호의 총 개수
        return openNeeded + closeNeeded;
    }
}
