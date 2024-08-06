import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력을 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 줄에서 N을 읽음
        int N = Integer.parseInt(br.readLine());
        
        // N개의 숫자를 저장할 배열 생성
        int[] numbers = new int[N];
        
        // 숫자들을 배열에 입력
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        
        // 배열을 오름차순으로 정렬
        Arrays.sort(numbers);
        
        // 정렬된 숫자들을 출력
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number).append('\n');
        }
        
        // 결과를 한 번에 출력
        System.out.print(sb.toString());
    }
}
