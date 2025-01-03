/*
첫 번째 줄:
구름이가 살펴본 문제 수 𝑁
5 ≤ 𝑁 ≤ 1,000

두 번째 줄:
각 난이도별로 풀어야 하는 문제 수 
𝑝1,𝑝2,𝑝3,𝑝4,𝑝5
 
𝑝1은 난이도 1 문제 수
𝑝2는 난이도 2 문제 수
𝑝3는 난이도 3 문제 수
𝑝4는 난이도 4 문제 수
𝑝5는 난이도 5 문제 수
1 ≤ 𝑝𝑖 < 𝑁

세 번째 줄부터 
𝑁개의 줄:
각 문제의 난이도 
𝑘𝑖와 푸는 데 걸리는 시간 𝑡𝑖

𝑘𝑖는 해당 문제의 난이도 
(1 ≤ 𝑘𝑖 ≤ 5)

𝑡𝑖는 해당 문제를 푸는 데 걸리는 시간 
(1≤ 𝑡𝑖 ≤ 300)

출력
계획한 문제를 푸는 데 필요한 최소 시간을 출력

같은 난이도 문제는 시간 차이만큼 휴식
난이도가 올라가면 60분 휴식
*/


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 문제 수 N
        int N = Integer.parseInt(br.readLine());

        //각 난이도별로 풀어야 하는 문제 수 p1, p2, p3, p4, p5
        st = new StringTokenizer(br.readLine());
        int[] targetCount = new int[6]; // 난이도 1~5 (0번 인덱스는 사용 안 함)
        for (int i = 1; i <= 5; i++) {
            targetCount[i] = Integer.parseInt(st.nextToken());
        }

        // 각 문제의 난이도와 풀이 시간 정보 
        List<int[]> problems = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int difficulty = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            problems.add(new int[]{difficulty, time});
        }

        // 난이도 오름차순 -> 같은 난이도에서는 시간 오름차순
        problems.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        int totalTime = 0; // 총 시간
        int prevDifficulty = 0; // 이전 문제 난이도
        int prevTime = 0; // 이전 문제 시간

        int[] selectedCount = new int[6]; // 선택한 문제 수 카운트

        for (int[] problem : problems) {
            int difficulty = problem[0];
            int time = problem[1];

            if (selectedCount[difficulty] < targetCount[difficulty]) {
                // 문제 선택
                totalTime += time;
                if (difficulty == prevDifficulty) {
                    // 같은 난이도일 때 휴식 시간: 이전 문제와 풀이 시간 차이만큼 추가
                    totalTime += Math.abs(time - prevTime);
                } else {
                    // 난이도가 바뀔 때 휴식 시간: 60분 추가
                    if (prevDifficulty != 0) {
                        totalTime += 60;
                    }
                }

                // 선택 카운트 및 이전 문제 정보 갱신
                selectedCount[difficulty]++;
                prevDifficulty = difficulty;
                prevTime = time;
            }
        }

        // 결과 출력
        System.out.println(totalTime);
    }
}
