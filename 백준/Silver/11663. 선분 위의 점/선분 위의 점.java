import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 점 입력받기
        int[] points = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }
        
        // 점 정렬
        Arrays.sort(points);
        
        // 결과를 저장할 StringBuilder
        StringBuilder sb = new StringBuilder();
        
        // 선분 입력받고 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            
            // 이진 탐색으로 범위 내 점의 개수 찾기
            int leftIdx = lowerBound(points, l);
            int rightIdx = upperBound(points, r) - 1; // upperBound는 초과 인덱스 반환
            
            // 개수 계산
            int count = Math.max(0, rightIdx - leftIdx + 1);
            sb.append(count).append("\n");
        }
        
        // 결과 출력
        System.out.print(sb);
    }

    // lowerBound: l 이상이 처음 나타나는 인덱스 반환
    private static int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // upperBound: r를 초과하는 첫 번째 인덱스 반환
    private static int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
