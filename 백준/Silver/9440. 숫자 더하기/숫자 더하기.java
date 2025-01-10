/*
입력
한 줄에 하나씩 연습문제가 주어진다.

각 줄에서 첫 번째로 나오는 정수 N (2 ≤ N ≤ 14) 은 연습문제에서 사용될 숫자의 개수이다.

두 번째부터 사용될 N개의 숫자가 주어진다. 0이 아닌 수가 최소 2개 이상 존재한다

마지막 줄에 0을 입력하면 프로그램이 종료된다.

출력
각 연습문제마다 정답을 출력

입력으로 주어진 숫자들을 두 그룹으로 나눠서 두 숫자를 만들고,
이 두 숫자의 합이 가장 작은 경우를 출력
정렬[1, 2, 7, 8, 9]
두 숫자를 번갈아가며 배치

첫 번째 숫자는 1을 num1에 넣고,
두 번째 숫자는 2를 num2에 넣고,
이렇게 번갈아가며 넣음
그룹 나누기 
Index	숫자	num1	num2
0	    1	1	
1	    2	1	2
2	    7	17	2
3	    8	17	28
4	    9	179	28

179 + 28 =  207
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            String[] input = line.split(" ");
            int N = Integer.parseInt(input[0]);

            if (N == 0) break;

            List<Integer> numbers = new ArrayList<>();
            int zeroCount = 0;
            for (int i = 1; i <= N; i++) {
                int num = Integer.parseInt(input[i]);
                if (num == 0) zeroCount++;
                numbers.add(num);
            }

            Collections.sort(numbers);

            // 0이 하나인 경우 처리
            if (zeroCount == 1) {
                Collections.swap(numbers, 0, 2);
            }

            // 0이 두 개 이상인 경우 처리
            if (zeroCount >= 2) {
                Collections.swap(numbers, 0, zeroCount);
                Collections.swap(numbers, 1, zeroCount + 1);
            }

            StringBuilder num1 = new StringBuilder();
            StringBuilder num2 = new StringBuilder();

            for (int i = 0; i < numbers.size(); i++) {
                if (i % 2 == 0) {
                    num1.append(numbers.get(i));
                } else {
                    num2.append(numbers.get(i));
                }
            }

            System.out.println(Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString()));
        }
    }
}
