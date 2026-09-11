class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        //민우가 산 로또 번호 6개 중 일부가 지워져서 0으로 표시됨
        //0은 "알 수 없는 숫자" — 아무 숫자로든 바뀔 수 있는 와일드카드
        //지워지지 않은 숫자는 그대로 확정된 값

        /*
        lottos에서 0의 개수 세기
        lottos와 win_nums에서 0이 아니면서 겹치는 숫자 개수 세기 (확정 일치 개수)
        최고 순위 = 순위표(확정 일치 + 0개수)
        최저 순위 = 순위표(확정 일치)
        [최고순위, 최저순위] 리턴
        */
        int zeroCount = 0;
        for (int l : lottos) {
            if (l == 0) zeroCount++;
        }

        int matchCount = 0;
        for (int l : lottos) {
            if (l == 0) continue;
            for (int w : win_nums) {
                if (l == w) {
                    matchCount++;
                    break;
                }
            }
        }

        int best = getRank(matchCount + zeroCount);
        int worst = getRank(matchCount);

        int[] answer = {best, worst};
        return answer;
    }

    private int getRank(int matchCount) {
        switch (matchCount) {
            case 6: return 1;
            case 5: return 2;
            case 4: return 3;
            case 3: return 4;
            case 2: return 5;
            default: return 6; // 0, 1개 일치는 낙첨
        }
    }
}