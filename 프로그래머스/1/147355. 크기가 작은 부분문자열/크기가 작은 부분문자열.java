class Solution {
    public int solution(String t, String p) {
        // t를 p의 길이만큼 추출해서 p보다 작거나 같은 경우의 수
        int count = 0;
        int lenP = p.length(); // p의 길이
        long numP = Long.parseLong(p); // p를 숫자로 변환 (긴 숫자를 위해 long 사용)

        // t에서 p의 길이만큼 부분 문자열을 추출하며 비교
        for (int i = 0; i <= t.length() - lenP; i++) {
            // 부분 문자열 추출 후 숫자로 변환
            long subNum = Long.parseLong(t.substring(i, i + lenP));
            
            // p보다 작거나 같으면 카운트 증가
            if (subNum <= numP) {
                count++;
            }
        }
        
        return count; // 최종 카운트 반환
    }
}