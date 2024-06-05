import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 막대기의 개수 N 입력 받기
        int N = scanner.nextInt();
        
        // 각 막대기의 높이를 담을 배열 선언
        int[] heights = new int[N];
        
        // 높이 입력 받기
        for (int i = 0; i < N; i++) {
            heights[i] = scanner.nextInt();
        }
        
        // 현재까지 본 가장 높은 막대기의 높이
        int maxHeight = 0;
        // 보이는 막대기의 개수
        int count = 0;
        
        // 오른쪽에서 왼쪽으로 탐색
        for (int i = N - 1; i >= 0; i--) {
            if (heights[i] > maxHeight) {
                count++;
                maxHeight = heights[i];
            }
        }
        
        // 결과 출력
        System.out.println(count);
        
        scanner.close();
    }
}
