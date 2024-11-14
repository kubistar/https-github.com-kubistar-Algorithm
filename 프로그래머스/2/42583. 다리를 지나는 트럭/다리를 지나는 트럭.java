import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 트럭 수 bridge_length,
        // 다리가 견딜 수 있는 무게 weight, 
        // 트럭 별 무게 truck_weights
        // 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 
        
        Queue<Integer> bridge = new LinkedList<>(); // 다리
        int bridgeweight = 0; // 다리 위 트럭의 총 무게
        int time = 0;     // 경과시간
        int index = 0;    // truck_weights 배열 인덱스
        
        for(int i=0; i<bridge_length; i++)
        {
            bridge.add(0);
        }
        
        
        while(index < truck_weights.length || bridgeweight > 0)
        {
            time++;
            
            bridgeweight -= bridge.poll();
            
            if(index < truck_weights.length)
            {
                if(bridgeweight + truck_weights[index] <= weight)
                {
                    bridge.add(truck_weights[index]);
                    bridgeweight += truck_weights[index];
                    index++;
                }
                else
                {
                    bridge.add(0);
                }
            }
        }
        
        
        return time;
    }
}