import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = br.readLine().split(" ");
        int C = Integer.parseInt(dimensions[0]); // 열의 개수
        int R = Integer.parseInt(dimensions[1]); // 행의 개수
        int K = Integer.parseInt(br.readLine()); // 대기 번호

        // 예외 처리: K가 좌석 수보다 크면 배정 불가
        if (K > C * R) {
            System.out.println(0);
            return;
        }

        // 방향 배열 (위, 오른쪽, 아래, 왼쪽 순서)
        int[] dx = {-1, 0, 1, 0}; // 행 변화량
        int[] dy = {0, 1, 0, -1}; // 열 변화량

        // 방문 여부를 기록할 배열
        boolean[][] visited = new boolean[R][C];

        // 초기 위치 및 방향 설정
        int x = R - 1, y = 0; // (1,1)이 (R-1,0)으로 시작
        int direction = 0; // 현재 이동 방향 (위쪽부터 시작)

        // 좌석 배정 카운트
        int count = 1;

        // K번째 좌석 찾기
        while (count < K) {
            // 현재 좌석 방문 처리
            visited[x][y] = true;

            // 다음 위치 계산
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            // 다음 위치가 범위를 벗어나거나 이미 방문했다면 방향 전환
            if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny]) {
                direction = (direction + 1) % 4; // 방향 전환
                nx = x + dx[direction];
                ny = y + dy[direction];
            }

            // 좌표 갱신 및 방문 카운트 증가
            x = nx;
            y = ny;
            count++;
        }

        // 결과 출력 (1-based indexing)
        System.out.println((y + 1) + " " + (R - x));
    }
}
