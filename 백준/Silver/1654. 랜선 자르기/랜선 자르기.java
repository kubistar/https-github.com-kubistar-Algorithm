/*
입력:
K: 이미 가지고 있는 랜선의 개수 (1 ≤ K ≤ 10,000)
N: 필요한 랜선의 개수 (1 ≤ N ≤ 1,000,000)
각 랜선의 길이: 자연수로 주어지며, 2^31-1 보다 작거나 같음.
    
로직:
이진 탐색:
left와 right를 설정하고, 중간 길이 mid를 계산
모든 랜선을 mid 길이로 잘라서 몇 개의 랜선이 나오는지 계산
잘라낸 랜선의 수가 N개 이상이면, 더 긴 랜선 길이도 가능한지 확인하기 위해 left를 늘리고, 
그렇지 않으면 right를 줄임
가능한 최대 랜선 길이를 result에 저장
    
출력:
N개의 랜선을 만들기 위해 가능한 최대 랜선의 길이 (cm 단위)
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // K와 N 값을 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());  // 이미 가지고 있는 랜선의 개수
        int N = Integer.parseInt(st.nextToken());  // 필요한 랜선의 개수
        
        // 각 랜선의 길이를 저장할 배열을 생성
        int[] lans = new int[K];
        
        // 주어진 랜선의 최대 길이를 찾기 위해 max 값을 설정
        long max = 0;
        
        for (int i = 0; i < K; i++) {
            lans[i] = Integer.parseInt(br.readLine());
            if (lans[i] > max) {
                max = lans[i];
            }
        }
        
        // 이진 탐색의 초기 설정: left는 1, right는 가장 긴 랜선의 길이로 설정
        long left = 1;
        long right = max;
        long result = 0;
        
        // 이진 탐색을 통해 랜선의 최대 길이를 찾음
        while (left <= right) {
            long mid = (left + right) / 2;  // 중간 값을 설정
            
            // mid 길이로 자른 랜선의 수를 세는 변수
            long count = 0;
            for (int i = 0; i < K; i++) {
                count += lans[i] / mid;
            }
            
            // 자른 랜선의 수가 N보다 크거나 같으면 더 긴 길이도 가능한지 확인
            if (count >= N) {
                result = mid;  // 현재 길이를 가능한 결과로 설정
                left = mid + 1;
            } else {
                right = mid - 1;  // 자른 랜선의 수가 부족하면 길이를 줄임
            }
        }
        
        // 결과를 출력
        System.out.println(result);
    }
}
