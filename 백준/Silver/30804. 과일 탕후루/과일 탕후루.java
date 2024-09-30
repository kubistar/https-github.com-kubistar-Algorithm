import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 이용한 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄에서 과일의 개수 N 읽기
        int N = Integer.parseInt(br.readLine().trim());
        
        // 두 번째 줄에서 과일 종류 배열 읽기
        String[] input = br.readLine().trim().split(" ");
        int[] fruits = new int[N];
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(input[i]);
        }
        
        // 슬라이딩 윈도우 알고리즘
        Map<Integer, Integer> fruitCount = new HashMap<>();
        int l = 0; // 왼쪽 포인터
        int maxLength = 0;
        
        for (int r = 0; r < N; r++) {
            // 오른쪽 끝의 과일 추가
            fruitCount.put(fruits[r], fruitCount.getOrDefault(fruits[r], 0) + 1);
            
            // 과일 종류가 2종류를 초과하는 경우 왼쪽 포인터 이동
            while (fruitCount.size() > 2) {
                fruitCount.put(fruits[l], fruitCount.get(fruits[l]) - 1);
                if (fruitCount.get(fruits[l]) == 0) {
                    fruitCount.remove(fruits[l]);
                }
                l++;
            }
            
            // 현재 윈도우의 길이로 최댓값 갱신
            maxLength = Math.max(maxLength, r - l + 1);
        }
        
        // 결과 출력
        System.out.println(maxLength);
    }
}
