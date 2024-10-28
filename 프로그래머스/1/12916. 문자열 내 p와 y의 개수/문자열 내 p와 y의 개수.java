class Solution {
    boolean solution(String s) {
        
        s = s.toLowerCase();
        
        int countP = 0;
        int countY = 0;
        
        // 문자열의 각 문자를 확인하며 'p'와 'y'를 카운트
        for (char ch : s.toCharArray()) {
            if (ch == 'p') {
                countP++;
            } else if (ch == 'y') {
                countY++;
            }
        }

        // 'p'와 'y'의 개수가 같은지 비교하여 결과를 반환
        return countP == countY;

         
    }
}