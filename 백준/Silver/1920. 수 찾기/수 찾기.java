import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄에서 N 읽기
        int N = Integer.parseInt(br.readLine());
        
        // 두 번째 줄에서 N개의 정수를 읽고 배열 A에 저장
        int[] A = new int[N];
        String[] inputA = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(inputA[i]);
        }
        
        // 배열 A를 정렬
        Arrays.sort(A);
        
        // 세 번째 줄에서 M 읽기
        int M = Integer.parseInt(br.readLine());
        
        // 네 번째 줄에서 M개의 정수를 읽고 배열 B에 저장
        String[] inputB = br.readLine().split(" ");
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(inputB[i]);
            // 이진 탐색으로 target이 A에 존재하는지 확인
            if (binarySearch(A, target)) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }
        
        // 결과 출력
        System.out.print(sb.toString());
    }
    
    // 이진 탐색 구현
    private static boolean binarySearch(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (A[mid] == target) {
                return true;
            } else if (A[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }
}
