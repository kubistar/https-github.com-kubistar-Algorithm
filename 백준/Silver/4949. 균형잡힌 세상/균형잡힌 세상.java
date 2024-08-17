import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            // 한 줄의 입력
            String line = br.readLine();
            
            // 입력이 "."이면 프로그램 종료
            if (line.equals(".")) {
                break;
            }
            
            // 균형 체크 후 결과 출력
            System.out.println(isBalanced(line));
        }
    }

    // 문자열이 균형을 이루고 있는지 확인하는 메서드
    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();  // 괄호를 저장할 스택 생성

        // 문자열의 각 문자를 순차적으로 탐색
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // 왼쪽 괄호일 경우 스택에 추가
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } 
            // 오른쪽 소괄호일 경우
            else if (ch == ')') {
                // 스택이 비어있거나, 스택의 최상단이 짝이 맞지 않으면 "no" 반환
                if (stack.isEmpty() || stack.peek() != '(') {
                    return "no";
                }
                stack.pop();  // 짝이 맞으면 스택에서 제거
            } 
            // 오른쪽 대괄호일 경우
            else if (ch == ']') {
                // 스택이 비어있거나, 스택의 최상단이 짝이 맞지 않으면 "no" 반환
                if (stack.isEmpty() || stack.peek() != '[') {
                    return "no";
                }
                stack.pop();  // 짝이 맞으면 스택에서 제거
            }
        }

        // 문자열을 다 처리한 후, 스택이 비어있으면 "yes" 반환
        return stack.isEmpty() ? "yes" : "no";
    }
}
