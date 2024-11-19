import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
         // 배열을 오름차순으로 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        // 두 배열을 순차적으로 비교하여 다른 이름이 나오면 반환
        for (int i = 0; i < completion.length; i++)         {
            if (!participant[i].equals(completion               [i])) {
                return participant[i];
            }
        }
        
        // 모든 이름이 일치하면 마지막 참가자가 완주하지 못한 선수
        return participant[participant.length - 1];
    }
}