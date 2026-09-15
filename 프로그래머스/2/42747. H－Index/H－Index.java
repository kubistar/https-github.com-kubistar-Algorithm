import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
       // 입력: 논문의 인용 횟수를 담은 배열 citations가 매개변수
    // 출력: 과학자의 H-Index를 return

        //  논문 n편 중, h번 이상 인용된 논문이 h편 이상이고
        //  나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index
        Arrays.sort(citations); // 오름차순 정렬 (in-place, 반환값 없음)

        int n = citations.length;
        for (int i = 0; i < n; i++) {
            // 뒤에서부터 세면 순위(rank) = n - i
            int rank = n - i;
            if (rank <= citations[i]) {
                return rank;
            }
        }
        return 0; 
    }
}