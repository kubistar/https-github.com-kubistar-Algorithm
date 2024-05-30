import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        // 문자열 입력 받기
        String input = reader.readLine().trim();
        
        // 문자열이 비어있는 경우, 단어 개수는 0
        if (input.isEmpty()) {
            System.out.println(0);
        } else {
            // 공백으로 문자열을 나누고 단어 배열 생성
            String[] words = input.split("\\s+");
            
            // 단어 개수 출력
            System.out.println(words.length);
        }
        
        reader.close();
    }
}