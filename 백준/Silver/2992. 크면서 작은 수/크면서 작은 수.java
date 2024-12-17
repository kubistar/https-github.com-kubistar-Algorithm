/*
입력
첫째 줄에 X가 주어진다. (1 ≤ X ≤ 999999) X는 0으로 시작하지 않는다.

출력
첫째 줄에 결과를 출력한다. 만약 그러한 숫자가 없는 경우에는 0을 출력한다.
*/

import java.io.*;

public class Main {
    static int minNumber = Integer.MAX_VALUE; // X보다 큰 가장 작은 수
    static boolean found = false; // 조건을 만족하는 수를 찾았는지 확인

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim(); // 입력된 숫자
        char[] digits = input.toCharArray(); // 숫자를 문자 배열로 변환

        int x = Integer.parseInt(input); // 입력한 숫자 

        // 순열 구하기
        permute(digits, 0, digits.length - 1, x);

        // 결과 출력
        if (found) {
            System.out.println(minNumber);
        } else {
            System.out.println(0);
        }
    }

    // 순열을 구하는 메서드 (재귀 방식)
    static void permute(char[] digits, int l, int r, int x) {
        if (l == r) {
            // 숫자로 변환하고 검사
            int permutedNumber = Integer.parseInt(new String(digits));
            if (permutedNumber > x) { // X보다 큰 경우
                minNumber = Math.min(minNumber, permutedNumber);
                found = true;
            }
        } else {
            for (int i = l; i <= r; i++) {
                swap(digits, l, i);
                permute(digits, l + 1, r, x);
                swap(digits, l, i); // 원상 복구
            }
        }
    }

    // 문자 배열의 두 요소를 교환하는 메서드
    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
