import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // BufferedReader를 사용하여 입력을 읽기 위한 설정
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            
            // 입력 문자열을 한 줄 읽음
            String longForm = reader.readLine();
            
            // 하이픈으로 문자열을 분리
            String[] parts = longForm.split("-");
            
            // 각 부분의 첫 글자를 추출하고 결과를 생성
            StringBuilder shortForm = new StringBuilder();
            for (String part : parts) {
                // 각 부분의 첫 글자를 StringBuilder에 추가
                shortForm.append(part.charAt(0));
            }
            
            // 결과 출력
            System.out.println(shortForm.toString());
        } catch (IOException e) {
            // 예외 발생 시 스택 트레이스를 출력하여 디버그
            e.printStackTrace();
        }
    }
}
