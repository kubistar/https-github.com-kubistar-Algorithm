import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int[][] matrix = new int[9][9];
        int maxVal = Integer.MIN_VALUE;
        int maxRow = -1;
        int maxCol = -1;

        // 9x9 행렬 입력 받기
        for (int i = 0; i < 9; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < 9; j++) {
                matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                
                // 현재 값을 최댓값과 비교
                if (matrix[i][j] > maxVal) {
                    maxVal = matrix[i][j];
                    maxRow = i + 1; // 행 번호는 1부터 시작하므로 +1
                    maxCol = j + 1; // 열 번호는 1부터 시작하므로 +1
                }
            }
        }

        // 최댓값 출력
        System.out.println(maxVal);
        // 최댓값 위치 출력
        System.out.println(maxRow + " " + maxCol);
    }
}
