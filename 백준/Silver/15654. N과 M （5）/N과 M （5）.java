/*
주어진 자연수 집합에서 길이가 𝑀인 모든 가능한 순열을 생성하는 문제
각 순열은 사전 순으로 출력되어야 하고 중복이 없어야 함

입력 조건

𝑁 자연수의 개수 (1 ≤ 𝑀 ≤ 𝑁 ≤ 8).
𝑀: 선택할 수열의 길이.
주어지는 자연수는 최대 8개이고, 10,000 이하의 자연수로 이루어져 있다.

출력 조건
각 수열은 사전 순으로 출력
각 수열의 원소는 공백으로 구분
수열은 중복되지 않게 출력
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] numbers;
    static boolean[] visited;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 𝑁 자연수의 개수
        M = Integer.parseInt(st.nextToken());   // 𝑀: 선택할 수열의 길이
        
        numbers = new int[N];
        visited = new boolean[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 배열을 사전 순 정렬
        Arrays.sort(numbers);

        // 백트래킹을 이용해 순열 생성 및 출력
        permute(0);

        // 최종 결과 출력
        System.out.println(sb);
    }

    // 순열을 생성하는 재귀 함수
    public static void permute(int depth) {
        // M개의 숫자를 선택한 경우, 결과 출력
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 순열을 만들기 위해 가능한 숫자 선택
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {  // 아직 선택하지 않은 숫자라면
                visited[i] = true;
                result[depth] = numbers[i];
                permute(depth + 1);
                visited[i] = false;  // 백트래킹
            }
        }
    }
}
