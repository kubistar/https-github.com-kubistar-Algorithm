import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 행렬의 크기 N과 M 입력 받기
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        // 행렬 A 입력 받기
        int[][] A = new int[N][M];
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        // 행렬 B 입력 받기
        int[][] B = new int[N][M];
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++) {
                B[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        // 행렬 덧셈 결과를 저장할 행렬 C 초기화
        int[][] C = new int[N][M];

        // 행렬 덧셈 수행
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        // 결과 출력
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                output.append(C[i][j]).append(" ");
            }
            output.append("\n");
        }

        // 결과를 출력
        System.out.print(output.toString());
    }
}
