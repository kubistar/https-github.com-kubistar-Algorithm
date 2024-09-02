/*
입력
첫째 줄에 사람의 수 N(1 ≤ N ≤ 1,000)이 주어진다. 
둘째 줄에는 각 사람이 돈을 인출하는데 걸리는 시간 Pi가 주어진다. (1 ≤ Pi ≤ 1,000)

출력
첫째 줄에 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값을 출력
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N 사람의 수 
        int N = Integer.parseInt(br.readLine());
        
        // 각 사람의 인출 시간
        String[] input = br.readLine().split(" ");
        int[] P = new int[N];
        
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(input[i]);
        }
        
        // 인출 시간을 오름차순으로 정렬
        Arrays.sort(P);
        
        int totalTime = 0;
        int sum = 0;
        
        // 각 사람이 인출하는데 걸리는 시간의 합 계산
        for (int i = 0; i < N; i++) {
            sum += P[i];
            totalTime += sum;
        }
        
        // 결과 출력
        System.out.println(totalTime);
    }
}
