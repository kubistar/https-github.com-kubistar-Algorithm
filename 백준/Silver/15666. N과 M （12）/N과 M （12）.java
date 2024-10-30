import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] numbers;
    static int[] result;
    static Set<String> resultSet = new LinkedHashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        numbers = new int[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);  // 사전 순 출력을 위해 정렬

        backtrack(0, 0);
        
        for (String s : resultSet) {
            sb.append(s).append('\n');
        }
        System.out.print(sb);
    }

    public static void backtrack(int depth, int start) {
        if (depth == M) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < M; i++) {
                temp.append(result[i]).append(' ');
            }
            resultSet.add(temp.toString());
            return;
        }

        for (int i = start; i < N; i++) {
            result[depth] = numbers[i];
            backtrack(depth + 1, i);  // 현재 선택한 인덱스부터 다시 시작 (중복 허용)
        }
    }
}
