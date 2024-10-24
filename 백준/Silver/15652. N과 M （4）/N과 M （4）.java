/*
문제
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램

1부터 N까지 자연수 중에서 M개를 고른 수열
같은 수를 여러 번 골라도 된다.
고른 수열은 비내림차순이어야 한다.
길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.

입력
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다.
중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] sequence;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 1부터 N까지의 자연수
        M = Integer.parseInt(st.nextToken()); // 수열의 길이

        sequence = new int[M]; // 선택한 수열을 저장할 배열

        // 백트래킹 함수 호출 (1부터 시작)
        backtrack(1, 0);

        // 결과 출력
        System.out.println(sb.toString());
    }

    //start는 현재 선택할 수 있는 최소 숫자, depth는 현재까지 선택한 숫자의 개수
    static void backtrack(int start, int depth) {
        // M개의 숫자를 모두 선택했을 때
        if (depth == M) {
            // 수열을 StringBuilder에 추가
            for (int i = 0; i < M; i++) {
                sb.append(sequence[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // start부터 N까지의 숫자를 선택
        for (int i = start; i <= N; i++) {
            sequence[depth] = i; // 현재 위치에 숫자 선택
            backtrack(i, depth + 1); // 재귀 호출 (같거나 큰 숫자를 선택)
        }
    }
}
