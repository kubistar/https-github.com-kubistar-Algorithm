/*
입력
첫째 줄에 N, M, B가 주어진다. (1 ≤ M, N ≤ 500, 0 ≤ B ≤ 6.4 × 107)

둘째 줄부터 N개의 줄에 각각 M개의 정수로 땅의 높이가 주어진다. 
(i + 2)번째 줄의 (j + 1)번째 수는 좌표 (i, j)에서의 땅의 높이를 나타낸다. 
땅의 높이는 256보다 작거나 같은 자연수 또는 0이다.

출력
첫째 줄에 땅을 고르는 데 걸리는 시간과 땅의 높이를 출력하시오. 
여러 개 있다면 그중에서 땅의 높이가 가장 높은 것을 출력
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //  가로
        int M = Integer.parseInt(st.nextToken());   // 세로
        int B = Integer.parseInt(st.nextToken());   // 블록갯수
        
        int[][] land = new int[N][M];        
        int minHeight = 256;
        int maxHeight = 0;
        
        // 입력받으면서 최소 높이, 최대 높이 찾기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                land[i][j] = Integer.parseInt(st.nextToken()); 
                if (land[i][j] < minHeight) minHeight = land[i][j];
                if (land[i][j] > maxHeight) maxHeight = land[i][j];
            }
        }
        
        int optimalTime = Integer.MAX_VALUE;
        int optimalHeight = -1;
        
        // 모든 높이에 대해 시도
        for (int targetHeight = minHeight; targetHeight <= maxHeight; targetHeight++) {
            int blocksToRemove = 0;
            int blocksToAdd = 0;
            
            // 현재 높이에서 필요한 블록 계산
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int currentHeight = land[i][j];
                    if (currentHeight > targetHeight) {
                        blocksToRemove += (currentHeight - targetHeight);
                    } else if (currentHeight < targetHeight) {
                        blocksToAdd += (targetHeight - currentHeight);
                    }
                }
            }
            
            // 인벤토리에 있는 블록으로 만들 수 있는지 확인
            if (blocksToAdd <= blocksToRemove + B) {
                int currentTime = blocksToRemove * 2 + blocksToAdd;
                
                // 최소 시간과 높이 갱신
                if (currentTime < optimalTime || (currentTime == optimalTime && targetHeight > optimalHeight)) {
                    optimalTime = currentTime;
                    optimalHeight = targetHeight;
                }
            }
        }
        
        System.out.println(optimalTime + " " + optimalHeight);
    }
}




