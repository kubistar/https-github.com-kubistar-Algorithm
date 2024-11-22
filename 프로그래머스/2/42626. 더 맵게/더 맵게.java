import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        // 배열의 모든 원소를 힙에 추가
        for (int s : scoville) {
            heap.add(s);
        }
        
        int mixCount = 0;
        
        // 섞기 작업 반복
        while (heap.size() > 1) {
            // 가장 작은 두 원소 꺼내기
            int first = heap.poll();
            if (first >= K) {
                return mixCount; // 이미 K 이상이면 종료
            }
            
            int second = heap.poll();
            int newScoville = first + (second * 2);
            heap.add(newScoville); // 새로운 값 힙에 추가
            mixCount++;
        }
        
        // 마지막 확인: 모든 음식이 K 이상인지
        return heap.peek() >= K ? mixCount : -1;
    }

}
