/*
입력
첫 번째 줄에는 테스트 케이스의 수 T(T ≤ 100)가 주어지고,

각 테스트 케이스마다 다음과 같은 정보가 주어진다.

첫 번째 줄에는 국가의 수 N(2 ≤ N ≤ 1 000)과 비행기의 종류 M(1 ≤ M ≤ 10 000) 가 주어진다.
이후 M개의 줄에 a와 b 쌍들이 입력된다. a와 b를 왕복하는 비행기가 있다는 것을 의미한다. 
(1 ≤ a, b ≤ n; a ≠ b) 
주어지는 비행 스케줄은 항상 연결 그래프를 이룬다.

출력
테스트 케이스마다 한 줄을 출력

상근이가 모든 국가를 여행하기 위해 타야 하는 비행기 종류의 최소 개수를 출력

*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 국가의 수
            int M = Integer.parseInt(st.nextToken()); // 비행기 종류의 수
            
            // 간선 정보 입력
            for (int i = 0; i < M; i++) {
                br.readLine();
            }
            
            // 최소 비행기 종류는 항상 N - 1
            sb.append(N - 1).append("\n");
        }
        
        System.out.println(sb);
    }
}
