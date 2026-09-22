public class Solution {
    public long solution(int k, int d) {

        //개수를 return" → 완전탐색(brute force)
        //제한사항이 k=1, d=1,000,000처럼 큼 → 완전탐색 그대로 쓰면 시간초과
        long answer = 0;
        long x = 0;
        long dd = (long) d * d;

        while (x * x <= dd) {
            long yMaxSq = dd - x * x;
            long yMax = (long) Math.sqrt(yMaxSq);

            // 부동소수점 오차 보정
            while ((yMax + 1) * (yMax + 1) <= yMaxSq) yMax++;
            while (yMax * yMax > yMaxSq) yMax--;

            answer += yMax / k + 1;
            x += k;
        }

        return answer;
    }
}