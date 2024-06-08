import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받기
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 구간의 합 계산
        int totalSum = 0;
        int currentNum = 1;
        int count = 0;
        
        for (int i = 1; i <= B; i++) {
            if (A <= i) {
                totalSum += currentNum;
            }
            count++;
            if (count == currentNum) {
                count = 0;
                currentNum++;
            }
        }

        // 결과 출력
        System.out.println(totalSum);
        
        br.close();
    }
}
