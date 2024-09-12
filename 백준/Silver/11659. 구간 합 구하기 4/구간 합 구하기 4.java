/*
첫째 줄:
N(수의 개수)과 M(구간 합을 구할 횟수)
N: 1 ≤ N ≤ 100,000
M: 1 ≤ M ≤ 100,000

둘째 줄:
N개의 수 (1 ≤ 각 수 ≤ 1,000)

셋째 줄
M개의 줄에 각각 두 개의 정수 i와 j가 주어지고 i번째 수부터 j번째 수까지의 합을 구해야 함 (1 ≤ i ≤ j ≤ N)

출력:
M개의 줄에 각각 구간 i부터 j까지의 합을 출력
*/


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N(수의 개수)과 M(구간 합을 구할 횟수)
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // N개의 수 입력 받음
        int[] arr = new int[N + 1];  // 1-based 인덱스 맞추기 위해 N+1 크기의 배열 선언
        int[] prefixSum = new int[N + 1];  // 누적 합 배열

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            // 누적 합 저장
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        // M개의 구간 합
        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < M; q++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            // i번째부터 j번째까지의 합을 구함
            int sum = prefixSum[j] - prefixSum[i - 1];
            sb.append(sum).append("\n");
        }

        // 결과 출력
        System.out.print(sb);
    }
}
