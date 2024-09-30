import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 과일 개수 N 입력
        int N = Integer.parseInt(br.readLine().trim());
        
        // 과일 종류 배열
        String[] input = br.readLine().trim().split(" ");
        int[] fruits = new int[N];
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(input[i]);
        }
        
        Deque<Integer> deque = new LinkedList<>();
        Map<Integer, Integer> fruitCount = new HashMap<>();
        
        int maxLength = 0;
        int l = 0;
        
        for (int r = 0; r < N; r++) {
            // 오른쪽 끝에 과일 추가
            int currentFruit = fruits[r];
            deque.addLast(currentFruit);
            fruitCount.put(currentFruit, fruitCount.getOrDefault(currentFruit, 0) + 1);
            
            // 과일 종류가 2종류를 초과하는 경우
            while (fruitCount.size() > 2) {
                int leftFruit = deque.pollFirst(); // 앞쪽 과일 제거
                fruitCount.put(leftFruit, fruitCount.get(leftFruit) - 1);
                
                if (fruitCount.get(leftFruit) == 0) {
                    fruitCount.remove(leftFruit);
                }
                
                l++; // 왼쪽 포인터 증가
            }
            
            // 현재 덱의 길이로 최댓값 갱신
            maxLength = Math.max(maxLength, r - l + 1);
        }
        
        // 결과 출력
        System.out.println(maxLength);
    }
}
