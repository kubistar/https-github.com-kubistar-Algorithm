import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 구멍갯수 N 입력
        int N = Integer.parseInt(br.readLine());

        //  구멍 크기 배열 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        // 도토리크기 Q 입력
        int Q = Integer.parseInt(br.readLine());

        // 도토리 크기 배열 입력
        st = new StringTokenizer(br.readLine());
        int[] s = new int[Q];
        for (int i = 0; i < Q; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        // 누적 최대값 배열 
        int[] effectiveA = new int[N];
        effectiveA[0] = a[0];
        for (int i = 1; i < N; i++) {
            effectiveA[i] = Math.max(effectiveA[i - 1], a[i] + i);
        }

        // 각 도토리 크기 이진 탐색 
        for (int size : s) {
            int index = binarySearch(effectiveA, size);
            sb.append(index + 1).append(" ");
        }

        // 결과 출력
        System.out.println(sb.toString().trim());
    }

    // 이진 탐색 
    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                right = mid - 1;  // 더 작은 인덱스를 탐색
            } else {
                left = mid + 1;   // 더 큰 인덱스를 탐색
            }
        }

        return left < arr.length ? left : arr.length - 1;  // 범위를 벗어나지 않도록 처리
    }
}
