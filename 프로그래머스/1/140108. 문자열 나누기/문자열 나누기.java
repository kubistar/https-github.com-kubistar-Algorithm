public class Solution {
    public int solution(String s) {
        int count = 0; // 분리된 문자열의 개수
        int countX = 0; // x와 같은 글자의 개수
        int countOther = 0; // x와 다른 글자의 개수
        
        char x = s.charAt(0); // 첫 번째 문자를 기준으로 설정
        
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            
            if (current == x) {
                countX++;
            } else {
                countOther++;
            }
            
            // 두 횟수가 같아진 경우 문자열을 분리
            if (countX == countOther) {
                count++;
                // 다음 부분 문자열을 위한 초기화
                if (i + 1 < s.length()) {
                    x = s.charAt(i + 1); // 다음 문자를 새로운 기준으로 설정
                }
                countX = 0;
                countOther = 0;
            }
        }
        
        // 남아있는 부분이 있다면 추가로 카운트
        if (countX != 0 || countOther != 0) {
            count++;
        }
        
        return count;
    }
    
}
