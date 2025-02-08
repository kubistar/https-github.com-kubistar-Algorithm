import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 수열 A 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> LIS = new ArrayList<>();

        // 이분 탐색을 활용한 LIS 구하기
        for (int num : A) {
            int pos = lowerBound(LIS, num);
            if (pos == LIS.size()) {
                LIS.add(num);  // 새로운 원소 추가
            } else {
                LIS.set(pos, num);  // 기존 위치의 원소 대체
            }
        }

        // 결과 출력: 가장 긴 증가하는 부분 수열의 길이
        System.out.println(LIS.size());
    }

    // 이분 탐색을 사용해 LIS에서 num이 들어갈 위치를 찾는 함수
    private static int lowerBound(ArrayList<Integer> list, int key) {
        int low = 0, high = list.size();

        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) < key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
