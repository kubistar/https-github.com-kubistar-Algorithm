/*
입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 
각 테스트 케이스의 첫째 줄에는 A의 수 N과 B의 수 M이 주어진다. 
둘째 줄에는 A의 크기가 모두 주어지며, 셋째 줄에는 B의 크기가 모두 주어진다. 
크기는 양의 정수이다. (1 ≤ N, M ≤ 20,000) 

출력
각 테스트 케이스마다, A가 B보다 큰 쌍의 개수를 출력

A의 각 원소와 B의 각 원소를 비교 -> 𝑂(𝑁×𝑀)  𝑁과 𝑀의 값이 최대 20,000인 경우 시간 초과


*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 개수 입력
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            // A와 B의 크기 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // A 배열 입력
            int[] A = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            // B 배열 입력
            int[] B = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            // B 배열 정렬
            Arrays.sort(B);

            // 결과 계산
            int count = 0;
            for (int a : A) {
                count += findSmallerCount(B, a);
            }

            // 결과 저장
            sb.append(count).append("\n");
        }

        // 최종 출력
        System.out.print(sb.toString());
    }

    // 이진 탐색으로 a보다 작은 값의 개수를 찾는 함수
    private static int findSmallerCount(int[] B, int a) {
        int low = 0;
        int high = B.length;

        // 이진 탐색 시작
        while (low < high) {
            int mid = (low + high) / 2;
            if (B[mid] < a) {
                low = mid + 1; // a보다 작으면 오른쪽 탐색
            } else {
                high = mid; // a 이상이면 왼쪽 탐색
            }
        }

        return low; // low가 a보다 작은 값의 개수
    }
}
