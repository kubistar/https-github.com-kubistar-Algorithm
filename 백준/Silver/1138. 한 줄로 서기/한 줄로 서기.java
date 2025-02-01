import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사람의 수 N 입력

        int N = Integer.parseInt(br.readLine());

        // 각 사람이 기억하는 정보 입력

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] remembers = new int[N];

        for (int i = 0; i < N; i++) {

            remembers[i] = Integer.parseInt(st.nextToken());

        }

        // 줄 서는 순서 결정

        int[] line = reconstructLine(N, remembers);

        // 결과 출력

        for (int i = 0; i < N; i++) {

            System.out.print(line[i] + " ");

        }

    }

    public static int[] reconstructLine(int N, int[] remembers) {

        int[] line = new int[N]; // 줄을 서는 순서를 저장할 배열

        for (int i = 0; i < N; i++) {

            int count = 0; // 현재까지 빈 자리의 개수

            for (int j = 0; j < N; j++) {

                if (line[j] == 0) { // 빈 자리인 경우

                    if (count == remembers[i]) { // 기억한 정보와 일치하는 위치

                        line[j] = i + 1; 

                        break;

                    }

                    count++; // 빈 자리 개수 증가

                }

            }

        }

        return line;

    }

}