import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // 입력된 값을 정수로 변환
        
        // 수열을 저장할 리스트
        List<Integer> ans = new ArrayList<>();
        
        // n이 짝수일 경우 1과 2를 번갈아 가면서 리스트에 추가
        for (int i = 0; i < n / 2; i++) {
            ans.add(1);  // 1 추가
            ans.add(2);  // 2 추가
        }
        
        // n이 홀수일 경우 마지막에 3을 추가
        if (n % 2 == 1) {
            ans.add(3);  // 3 추가
        }
        
        // 리스트의 요소들을 출력
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i));  // 요소 출력
            if (i < ans.size() - 1) {  // 마지막 요소가 아니면 공백 추가
                System.out.print(" ");
            }
        }
        
        // BufferedReader를 닫음
        if (br != null) {
            br.close();
        }
    }
}
