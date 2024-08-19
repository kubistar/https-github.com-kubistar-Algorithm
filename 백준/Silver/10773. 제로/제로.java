import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력의 첫 번째 줄에서 K 값 받기
        int K = Integer.parseInt(br.readLine());
        
        // 스택 생성
        Stack<Integer> stack = new Stack<>();
        
        // K번 만큼 입력받기
        for (int i = 0; i < K; i++) {
            int number = Integer.parseInt(br.readLine());
            
            // 입력된 값이 0이라면 스택에서 최근 숫자를 제거
            if (number == 0) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // 입력된 값이 0이 아니라면 스택에 추가
                stack.push(number);
            }
        }
        
        // 스택에 남아 있는 모든 값의 합을 계산
        int sum = 0;
        for (int num : stack) {
            sum += num;
        }
        
        // 결과 출력
        System.out.println(sum);
    }
}
