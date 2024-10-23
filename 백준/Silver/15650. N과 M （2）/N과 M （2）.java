/*
문제
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성

1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
고른 수열은 오름차순이어야 한다.

입력
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 
각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // N: 1부터 N까지의 자연수
        int M = Integer.parseInt(st.nextToken());  // M: 고를 숫자의 개수

        // 결과를 저장할 배열
        int[] result = new int[M];
        // 백트래킹 시작
        backtrack(1, 0, N, M, result);
    }

    // 백트래킹 함수
    public static void backtrack(int start, int depth, int N, int M, int[] result) {
        // M개의 숫자를 모두 선택한 경우 출력
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        // start부터 N까지 숫자를 선택
        for (int i = start; i <= N; i++) {
            result[depth] = i;
            backtrack(i + 1, depth + 1, N, M, result);
        }
    }
}
