/*
입력
첫째 줄에 N(2 ≤ N ≤ 50)과 M(1 ≤ M ≤ 13)이 주어진다.

둘째 줄부터 N개의 줄에는 도시의 정보가 주어진다.

도시의 정보는 0, 1, 2로 이루어져 있고, 0은 빈 칸, 1은 집, 2는 치킨집을 의미한다. 
집의 개수는 2N개를 넘지 않으며, 적어도 1개는 존재한다. 
치킨집의 개수는 M보다 크거나 같고, 13보다 작거나 같다.

출력
첫째 줄에 폐업시키지 않을 치킨집을 최대 M개를 골랐을 때, 도시의 치킨 거리의 최솟값을 출력

*/


import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<int[]> homes = new ArrayList<>();
    static List<int[]> chickenShops = new ArrayList<>();
    static int minCityChickenDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
       
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //  N (도시 크기)
        M = Integer.parseInt(st.nextToken());// M (남길 치킨집 개수)
        
        // 도시 정보를 읽어서 집과 치킨집 위치를 저장
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    homes.add(new int[]{r, c}); // 집 위치 추가
                } else if (value == 2) {
                    chickenShops.add(new int[]{r, c}); // 치킨집 위치 추가
                }
            }
        }
        
        // M개의 치킨집을 고르는 조합 생성 및 최소 치킨 거리 계산
        combination(0, 0, new int[M][2]);
        
        // 결과 출력
        System.out.println(minCityChickenDistance);
    }

    // 조합을 통해 M개의 치킨집을 선택하는 메서드
    static void combination(int start, int depth, int[][] selectedShops) {
        if (depth == M) {
            // 선택된 치킨집으로 도시 치킨 거리 계산
            minCityChickenDistance = Math.min(minCityChickenDistance, calculateCityChickenDistance(selectedShops));
            return;
        }
        
        for (int i = start; i < chickenShops.size(); i++) {
            selectedShops[depth] = chickenShops.get(i);
            combination(i + 1, depth + 1, selectedShops);
        }
    }

    // 선택된 치킨집들로부터 도시의 치킨 거리 계산
    static int calculateCityChickenDistance(int[][] selectedShops) {
        int totalDistance = 0;

        for (int[] home : homes) {
            int homeDistance = Integer.MAX_VALUE;
            for (int[] shop : selectedShops) {
                int distance = Math.abs(home[0] - shop[0]) + Math.abs(home[1] - shop[1]);
                homeDistance = Math.min(homeDistance, distance);
            }
            totalDistance += homeDistance;
        }

        return totalDistance;
    }
}
