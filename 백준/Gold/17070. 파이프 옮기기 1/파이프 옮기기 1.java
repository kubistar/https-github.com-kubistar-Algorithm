/*
입력
첫째 줄에 집의 크기 N(3 ≤ N ≤ 16)이 주어진다. 둘째 줄부터 N개의 줄에는 집의 상태가 주어진다. 
빈 칸은 0, 벽은 1로 주어진다. (1, 1)과 (1, 2)는 항상 빈 칸이다.

출력
첫째 줄에 파이프의 한쪽 끝을 (N, N)으로 이동시키는 방법의 수를 출력한다. 
이동시킬 수 없는 경우에는 0을 출력한다. 방법의 수는 항상 1,000,000보다 작거나 같다.

가로로 이동 (→)
세로로 이동 (↓)
대각선으로 이동 (↘)

파이프는 2개의 연속된 칸을 차지하며 처음에는 (1, 1)과 (1, 2)에 가로 방향으로 놓여 있다.
이후에는  방향을 변경하며 이동할 수 있다.
가로 방향일 때: 오른쪽(→) 또는 대각선(↘)으로 이동 가능
세로 방향일 때: 아래(↓) 또는 대각선(↘)으로 이동 가능
대각선 방향일 때: 오른쪽(→), 아래(↓), 대각선(↘) 모두 이동 가능
 
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] grid;
    static int[][][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        dp = new int[N][N][3]; // 3개의 방향: 0 - 가로, 1 - 세로, 2 - 대각선
        
        // 입력 
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 시작 지점 초기화: (0, 1) - 가로 상태
        dp[0][1][0] = 1;
        
        // DP 
        for (int r = 0; r < N; r++) {
            for (int c = 1; c < N; c++) {
                if (grid[r][c] == 1) continue; // 벽인 경우는 건너뜀
                
                // 가로 상태 (0)
                // 현재 위치 (r, c)에 가로로 도달할 수 있는 경우의 수 계산
                if (c > 0) {
                    dp[r][c][0] += dp[r][c - 1][0]; // 이전 위치에서 가로로 오는 경우
                    dp[r][c][0] += dp[r][c - 1][2]; // 이전 위치에서 대각선으로 오는 경우
                }
                
                // 세로 상태 (1)
                // 현재 위치 (r, c)에 세로로 도달할 수 있는 경우의 수 계산
                if (r > 0) {
                    dp[r][c][1] += dp[r - 1][c][1]; // 이전 위치에서 세로로 오는 경우
                    dp[r][c][1] += dp[r - 1][c][2]; // 이전 위치에서 대각선으로 오는 경우
                }
                
                // 대각선 상태 (2)
                // 현재 위치 (r, c)에 대각선으로 도달할 수 있는 경우의 수 계산
                if (r > 0 && c > 0 && grid[r][c - 1] == 0 && grid[r - 1][c] == 0 && grid[r - 1][c - 1] == 0) {
                    dp[r][c][2] += dp[r - 1][c - 1][0]; // 이전 위치에서 가로로 오는 경우
                    dp[r][c][2] += dp[r - 1][c - 1][1]; // 이전 위치에서 세로로 오는 경우
                    dp[r][c][2] += dp[r - 1][c - 1][2]; // 이전 위치에서 대각선으로 오는 경우
                }
            }
        }
        
        // (N-1, N-1)에 도달하는 모든 방향의 경우의 수
        int result = dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2];
        System.out.println(result);
    }
}
