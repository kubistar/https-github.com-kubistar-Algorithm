import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 방의 크기 N 입력 받기
        int N = Integer.parseInt(br.readLine().trim());
        char[][] room = new char[N][N];
        
        // 방의 구조 입력 받기
        for (int i = 0; i < N; i++) {
            room[i] = br.readLine().toCharArray();
        }
        
        int horizontalCount = 0;
        int verticalCount = 0;
        
        // 가로로 누울 자리 찾기
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (room[i][j] == '.') {
                    count++;
                } else {
                    if (count >= 2) {
                        horizontalCount++;
                    }
                    count = 0;
                }
            }
            if (count >= 2) {
                horizontalCount++;
            }
        }
        
        // 세로로 누울 자리 찾기
        for (int j = 0; j < N; j++) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (room[i][j] == '.') {
                    count++;
                } else {
                    if (count >= 2) {
                        verticalCount++;
                    }
                    count = 0;
                }
            }
            if (count >= 2) {
                verticalCount++;
            }
        }
        
        // 결과 출력
        System.out.println(horizontalCount + " " + verticalCount);
    }
}
