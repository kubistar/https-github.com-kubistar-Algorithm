/*
입력
첫째 줄에 조각의 수 N이 주어진다. (1 ≤ N ≤ 100,000)
다음 N개의 줄에는 노래의 길이 D와 다운로드하는데 걸리는 시간 V가 주어진다. (1 ≤ D,V ≤ 1000)

출력
첫째 줄에, 다운로드 시작하고 몇 초 후에 노래를 듣기 시작하면, 끊김 없이 들을 수 있는지 출력한다.
그러한 시간이 여러개라면, 가장 빠른 것을 출력한다.

조각들은 정해진 순서대로 다운로드해야 하고, 다운로드가 완료된 조각만 재생 가능
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 크기 N
        int N = Integer.parseInt(br.readLine());

        // 조각 정보 저장
        int[][] S = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()); // 재생 시간 D
            int v = Integer.parseInt(st.nextToken()); // 다운로드 시간 V
            S[i][0] = d;
            S[i][1] = v;
        }

        // 정답 변수와 현재 다운로드된 노래 조각의 길이
        int ans = 0; 
        int l = 0; // 현재 다운로드된 길이

        for (int i = 0; i < N; i++) {
            int d = S[i][0]; // 재생 시간
            int v = S[i][1]; // 다운로드 시간

            // 현재 다운로드 길이에서 다운로드 시간을 차감
            l -= v;

            // 다운로드 시간이 더 길어 부족한 경우 대기 시간을 추가
            if (l < 0) {
                ans -= l; // 부족한 만큼 정답에 추가
                l = 0; // 다운로드 길이를 0으로 초기화
            }

            // 현재 조각의 재생 길이만큼 다운로드 길이 추가
            l += d;
        }

        // 결과 출력
        System.out.println(ans);
    }
}
