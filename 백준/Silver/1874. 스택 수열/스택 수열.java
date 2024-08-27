/*
스택을 통해 수열을 만들 수 있으면 +와 -를 출력하고, 그렇지 않으면 "NO"를 출력
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine()); // 첫 줄에서 n을 입력받음
        int[] sequence = new int[n];
        
        // 주어진 수열 입력받기
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }
        
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 1;
        boolean possible = true;
        
        for (int i = 0; i < n; i++) {
            int target = sequence[i];
            
            if (currentNumber <= target) {
                // target까지 스택에 넣는다.
                while (currentNumber <= target) {
                    stack.push(currentNumber++);
                    sb.append("+\n");
                }
            }
            
            // 스택의 최상단 값이 target이면 pop
            if (stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                possible = false;
                break;
            }
        }
        
        if (possible) {
            System.out.println(sb.toString());
        } else {
            System.out.println("NO");
        }
    }
}
