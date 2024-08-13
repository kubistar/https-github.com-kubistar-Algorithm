/*
N×M 보드에서 8×8 크기의 모든 가능성을 체크한 후, 최소 칠해야 하는 칸 수
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받기
        String[] dimensions = br.readLine().split(" ");
        int n = Integer.parseInt(dimensions[0]);
        int m = Integer.parseInt(dimensions[1]);

        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int minRecolor = Integer.MAX_VALUE;

        // 모든 8x8 크기의 체스판 영역을 확인
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                minRecolor = Math.min(minRecolor, findMinRecolor(board, i, j));
            }
        }

        System.out.println(minRecolor);
    }

    // 주어진 좌표 (startRow, startCol)에서 8x8 체스판으로 만드는 데 필요한 최소 칠하기 수를 계산
    private static int findMinRecolor(char[][] board, int startRow, int startCol) {
        int recolorW = 0; // 맨 왼쪽 위 칸이 'W'인 경우
        int recolorB = 0; // 맨 왼쪽 위 칸이 'B'인 경우

        // 8x8 크기의 체스판을 확인
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // 예상 색깔을 계산
                char expectedW = ((i + j) % 2 == 0) ? 'W' : 'B';
                char expectedB = ((i + j) % 2 == 0) ? 'B' : 'W';

                // 실제 보드 색깔과 비교
                if (board[startRow + i][startCol + j] != expectedW) {
                    recolorW++;
                }
                if (board[startRow + i][startCol + j] != expectedB) {
                    recolorB++;
                }
            }
        }

        // 둘 중 최소 값을 반환
        return Math.min(recolorW, recolorB);
    }
}
