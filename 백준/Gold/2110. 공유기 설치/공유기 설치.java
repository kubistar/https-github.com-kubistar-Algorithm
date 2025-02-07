import java.io.*;

import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int C = Integer.parseInt(st.nextToken());

        int[] houses = new int[N];

        for (int i = 0; i < N; i++) {

            houses[i] = Integer.parseInt(br.readLine());

        }

        Arrays.sort(houses);

        int left = 1;

        int right = houses[N - 1] - houses[0];

        int result = 0;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (canInstall(houses, C, mid)) {

                result = mid;

                left = mid + 1;

            } else {

                right = mid - 1;

            }

        }

        System.out.println(result);

    }

    private static boolean canInstall(int[] houses, int C, int distance) {

        int count = 1;  // 첫 번째 집에 설치

        int lastInstalled = houses[0];

        for (int i = 1; i < houses.length; i++) {

            if (houses[i] - lastInstalled >= distance) {

                count++;

                lastInstalled = houses[i];

            }

            if (count >= C) {

                return true;

            }

        }

        return false;

    }

}

