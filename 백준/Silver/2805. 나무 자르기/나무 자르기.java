/*

입력
첫째 줄에 나무의 수 N과 상근이가 집으로 가져가려고 하는 나무의 길이 M이 주어진다. 
(1 ≤ N ≤ 1,000,000, 1 ≤ M ≤ 2,000,000,000)

둘째 줄에는 나무의 높이가 주어진다. 
나무의 높이의 합은 항상 M보다 크거나 같기 때문에, 상근이는 집에 필요한 나무를 항상 가져갈 수 있다. 
높이는 1,000,000,000보다 작거나 같은 양의 정수 또는 0이다.

출력
적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값을 출력한다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 나무의 수
        long M = Long.parseLong(st.nextToken()); // 필요한 나무 길이

        // 나무 높이 입력
        long[] trees = new long[N];
        st = new StringTokenizer(br.readLine());
        long maxTreeHeight = 0; // 최대 나무 높이 찾기

        for (int i = 0; i < N; i++) {
            trees[i] = Long.parseLong(st.nextToken());
            if (trees[i] > maxTreeHeight) {
                maxTreeHeight = trees[i];
            }
        }

        // 이진 탐색을 위한 초기 범위 설정
        long start = 0;
        long end = maxTreeHeight;
        long answer = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long cutLength = 0;

            // 현재 높이로 잘랐을 때의 나무 총합 계산
            for (long height : trees) {
                if (height > mid) {
                    cutLength += (height - mid);
                }
            }

            // 필요한 나무 길이보다 충분한 경우
            if (cutLength >= M) {
                answer = mid; // 현재 높이를 저장
                start = mid + 1; // 더 큰 높이에서 시도
            } else {
                end = mid - 1; // 더 낮은 높이에서 시도
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}

