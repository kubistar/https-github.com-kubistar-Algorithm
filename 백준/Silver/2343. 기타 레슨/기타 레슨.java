import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 강의 수
        int M = Integer.parseInt(st.nextToken()); // 블루레이 수

        int[] lectures = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        int sum = 0;

        // 강의 길이 입력받기
        for (int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, lectures[i]); // 가장 긴 강의 길이
            sum += lectures[i];
        }

        // 이진 탐색
        int low = max; // 최소 블루레이 크기는 가장 긴 강의 길이
        int high = sum; // 최대 블루레이 크기는 모든 강의를 한 블루레이에 담는 경우
        int result = high;

        while (low <= high) {
            int mid = (low + high) / 2; // 블루레이 크기

            if (isPossible(lectures, N, M, mid)) {
                result = mid; // 가능한 경우 결과 갱신
                high = mid - 1; // 더 작은 블루레이 크기 시도
            } else {
                low = mid + 1; // 블루레이 크기 증가
            }
        }

        System.out.println(result);
    }

    // 주어진 블루레이 크기로 모든 강의를 M개의 블루레이에 담을 수 있는지 확인
    private static boolean isPossible(int[] lectures, int N, int M, int size) {
        int count = 1; // 필요한 블루레이 개수
        int sum = 0;

        for (int lecture : lectures) {
            if (sum + lecture > size) {
                count++; // 새로운 블루레이 필요
                sum = lecture; // 현재 강의를 새로운 블루레이에 담음

                if (count > M) { // 블루레이 개수가 M을 초과하면 불가능
                    return false;
                }
            } else {
                sum += lecture; // 현재 블루레이에 강의 추가
            }
        }

        return true;
    }
}
