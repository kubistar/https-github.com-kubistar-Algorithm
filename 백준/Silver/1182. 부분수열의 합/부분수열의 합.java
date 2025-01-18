import java.io.*;
import java.util.*;

public class Main {
    static int N, S, count = 0;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        findSubsequences(0, 0);
        if (S == 0) count--; // S가 0인 경우 공집합 제외
        System.out.println(count);
    }

    static void findSubsequences(int idx, int currentSum) {
        if (idx == N) {
            if (currentSum == S) {
                count++;
            }
            return;
        }

        // 현재 숫자를 포함하는 경우
        findSubsequences(idx + 1, currentSum + nums[idx]);

        // 현재 숫자를 포함하지 않는 경우
        findSubsequences(idx + 1, currentSum);
    }
}
