/*
M번의 인출 횟수로 N일 동안 모든 지출을 충당하면서, 인출 금액 K를 최소화

*/


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 일 수
        int M = Integer.parseInt(input[1]); // 인출 횟수
        
        int[] money = new int[N];
        int maxExpense = 0;
        int totalExpense = 0;
        
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
            maxExpense = Math.max(maxExpense, money[i]); // 가장 큰 지출
            totalExpense += money[i]; // 전체 지출 합
        }

        // 이분 탐색 (K 최소값을 구하기)
        int left = maxExpense; // 최소 인출 금액 (최소 하루 지출)
        int right = totalExpense; // 최대 인출 금액 (한 번에 모든 지출)
        int answer = totalExpense;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canWithdraw(money, mid, M)) {
                answer = mid; // 최소 금액을 찾음
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    // mid 금액으로 M번 이하의 인출로 모든 날을 커버할 수 있는지 체크
    public static boolean canWithdraw(int[] money, int mid, int M) {
        int count = 1; // 인출 횟수 (최소 1번)
        int sum = 0;

        for (int m : money) {
            if (sum + m > mid) { // 현재 금액으로 감당 안 되면 인출
                count++;
                sum = 0;
            }
            sum += m;
        }

        return count <= M; // M번 이하로 인출 가능해야 함
    }
}
