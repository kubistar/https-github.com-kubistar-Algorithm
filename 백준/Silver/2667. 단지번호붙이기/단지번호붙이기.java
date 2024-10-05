/*

입력
첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.

출력
첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력

*/

import java.io.*;
import java.util.*;

public class Main {
    static int N; // 지도의 크기
    static int[][] map; // 지도 정보
    static boolean[][] visited; // 방문 여부 확인
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동을 위한 배열
    static int[] dy = {0, 0, -1, 1}; // 상하좌우 이동을 위한 배열
    static int houseCount; // 각 단지 내 집의 수를 세기 위한 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 지도의 크기 입력
        map = new int[N][N];
        visited = new boolean[N][N];

        // 지도 정보 입력
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0'; // 문자열을 숫자로 변환
            }
        }

        List<Integer> houseCounts = new ArrayList<>(); // 각 단지의 집의 수 저장

        // 지도 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 집이 있고 아직 방문하지 않은 경우
                if (map[i][j] == 1 && !visited[i][j]) {
                    houseCount = 0; // 단지 내 집의 수 초기화
                    dfs(i, j); // DFS로 단지를 찾음
                    houseCounts.add(houseCount); // 단지 내 집의 수 추가
                }
            }
        }

        // 결과 출력
        Collections.sort(houseCounts); // 집의 수를 오름차순으로 정렬
        System.out.println(houseCounts.size()); // 단지 수 출력
        for (int count : houseCounts) {
            System.out.println(count); // 각 단지 내 집의 수 출력
        }
    }

    // DFS 탐색
    static void dfs(int x, int y) {
        visited[x][y] = true; // 방문 처리
        houseCount++; // 현재 단지 내 집의 수 증가

        // 상하좌우로 이동하며 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 지도 범위를 벗어나지 않고, 집이 있으며, 아직 방문하지 않은 경우
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny); // 재귀적으로 DFS 탐색
                }
            }
        }
    }
}
