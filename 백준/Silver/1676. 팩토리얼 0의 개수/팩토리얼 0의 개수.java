import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // BufferedReader로 입력받기
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(reader.readLine().trim());
            
            // 0의 개수를 세는 함수 호출
            int result = countTrailingZeros(n);
            
            // 결과 출력
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static int countTrailingZeros(int n) {
        int count = 0;
        for (int i = 5; n / i > 0; i *= 5) {
            count += n / i;
        }
        return count;
    }
}
