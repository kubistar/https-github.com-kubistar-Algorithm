/*
입력
첫째 줄에는 전체 종이의 한 변의 길이 N이 주어져 있다. N은 2, 4, 8, 16, 32, 64, 128 중 하나이다. 
색종이의 각 가로줄의 정사각형칸들의 색이 윗줄부터 차례로 둘째 줄부터 마지막 줄까지 주어진다. 
하얀색으로 칠해진 칸은 0, 파란색으로 칠해진 칸은 1로 주어지며, 각 숫자 사이에는 빈칸이 하나씩 있다.

출력
첫째 줄에는 잘라진 햐얀색 색종이의 개수를 출력하고, 둘째 줄에는 파란색 색종이의 개수를 출력한다.


종이가 모두 같은 색으로 칠해져 있다면, 더 이상 자르지 않고 그 색종이의 수를 1로 카운트
같은 색이 아닌 경우 분할하기
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[][] paper;
    static int whiteCount = 0; // 하얀색 색종이 수
    static int blueCount = 0;  // 파란색 색종이 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N 입력 받기
        int N = Integer.parseInt(br.readLine());
        
        // N x N 종이의 색 정보를 입력 받아 2차원 배열에 저장
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 재귀적으로 종이를 자르기 시작
        countPaper(0, 0, N);
        
        // 결과 출력
        System.out.println(whiteCount);
        System.out.println(blueCount);
    }

    // 종이를 자르고 색종이의 수를 세는 재귀 함수
    static void countPaper(int x, int y, int size) {
        int color = paper[x][y];
        
        if (isSameColor(x, y, size, color)) {
            // 모든 영역이 같은 색일 경우 해당 색의 색종이 수 증가
            if (color == 0) {
                whiteCount++;
            } else {
                blueCount++;
            }
        } else {
            // 색상이 다를 경우 4개의 작은 색종이로 분할하여 재귀적으로 처리
            int newSize = size / 2;
            countPaper(x, y, newSize); // 1사분면
            countPaper(x, y + newSize, newSize); // 2사분면
            countPaper(x + newSize, y, newSize); // 3사분면
            countPaper(x + newSize, y + newSize, newSize); // 4사분면
        }
    }

    // 주어진 영역이 모두 같은 색인지 확인하는 함수
    static boolean isSameColor(int x, int y, int size, int color) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}

