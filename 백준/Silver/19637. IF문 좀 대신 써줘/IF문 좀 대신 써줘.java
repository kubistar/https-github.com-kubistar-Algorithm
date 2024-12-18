/*
입력
첫 번째 줄에는 칭호의 개수 N (1 ≤ N ≤ 105)과 
칭호를 출력해야 하는 캐릭터들의 개수 M (1 ≤ M ≤ 105)
(1 ≤ N, M ≤ 105)

두 번째 줄부터 N개의 줄에 각 칭호의 이름을 나타내는 길이 1 이상, 11 이하의 영어 대문자로만 구성된 문자열
해당 칭호의 전투력 상한값을 나타내는 109 이하의 음이 아닌 정수가 주어진다. 
칭호는 전투력 상한값의 비내림차순으로 주어진다. 

N + 2번째 줄부터 M개의 각 줄에는 캐릭터의 전투력을 나타내는 음이 아닌 정수가 주어진다. 
해당하는 칭호가 없는 전투력은 입력으로 주어지지 않는다.

출력
M개의 줄에 걸쳐 캐릭터의 전투력에 맞는 칭호를 입력 순서대로 출력한다. 
어떤 캐릭터의 전투력으로 출력할 수 있는 칭호가 여러 개인 경우 가장 먼저 입력된 칭호 하나만 출력한다.
*/


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); 

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // N(칭호 수)
        int M = Integer.parseInt(st.nextToken());  // M(캐릭터 수)

        // 칭호와 상한값 배열
        String[] titles = new String[N];
        int[] limits = new int[N];

        // N개의 칭호와 상한값 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            titles[i] = st.nextToken(); // 칭호
            limits[i] = Integer.parseInt(st.nextToken()); // 상한값
        }

        // M개의 캐릭터 전투력 입력
        for (int i = 0; i < M; i++) {
            int power = Integer.parseInt(br.readLine());

            // 이진 탐색으로 해당 칭호 찾기
            int idx = binarySearch(limits, power);
            sb.append(titles[idx]).append("\n");
        }

        // 결과 출력
        System.out.print(sb.toString());
    }

    // 이진 탐색: 상한값 배열에서 power보다 크거나 같은 최소 인덱스 반환
    private static int binarySearch(int[] limits, int power) {
        int left = 0;
        int right = limits.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (limits[mid] >= power) {
                right = mid; // 현재 mid가 조건을 만족하므로 더 작은 범위를 탐색
            } else {
                left = mid + 1; // 현재 mid가 조건을 만족하지 않으므로 더 큰 범위를 탐색
            }
        }

        return left; // left가 조건을 만족하는 최소 인덱스
    }
}
