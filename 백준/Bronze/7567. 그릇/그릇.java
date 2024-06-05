import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 괄호 문자열을 입력 받습니다.
        String brackets = br.readLine();

        // 그릇의 높이를 계산할 변수를 초기화합니다.
        int height = 10; // 바닥에 놓인 그릇의 높이

        // 이전 그릇의 방향을 저장할 변수를 초기화합니다.
        char prevBracket = brackets.charAt(0);

        // 괄호 문자열을 순회하며 그릇의 방향을 판단합니다.
        for (int i = 1; i < brackets.length(); i++) {
            char currentBracket = brackets.charAt(i);

            // 이전 그릇과 현재 그릇의 방향이 같은 경우
            if (prevBracket == currentBracket) {
                // 같은 방향으로 포개면 높이는 5cm 증가합니다.
                height += 5;
            } 
            // 이전 그릇과 현재 그릇의 방향이 다른 경우
            else {
                // 반대 방향으로 쌓이면 높이는 10cm 증가합니다.
                height += 10;
            }

            // 현재 그릇의 방향을 이전 그릇의 방향으로 갱신합니다.
            prevBracket = currentBracket;
        }

        // 전체의 높이를 출력합니다.
        System.out.println(height);

        br.close();
    }
}
