import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.io.IOException;

import java.util.Arrays;

public class Main {

    static int N;

    static int[] arr;

    static boolean[] used;

    static int[] output;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        used = new boolean[N];

        output = new int[N];

        for (int i = 0; i < N; i++) {

            arr[i] = i + 1; // 1부터 N까지 배열 초기화

        }

        Arrays.sort(arr); 

        backtrack(0);

    }

    static void backtrack(int depth) {

        if (depth == N) {

            for (int i = 0; i < N; i++) {

                System.out.print(output[i] + " ");

            }

            System.out.println();

            return;

        }

        for (int i = 0; i < N; i++) {

            if (!used[i]) {

                used[i] = true;

                output[depth] = arr[i];

                backtrack(depth + 1);

                used[i] = false; // 백트래킹을 위해 선택 해제

            }

        }

    }

}

