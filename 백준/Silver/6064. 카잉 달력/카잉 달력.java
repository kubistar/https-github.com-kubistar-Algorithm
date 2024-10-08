/*
입력
입력 데이터는 표준 입력을 사용한다. 입력은 T개의 테스트 데이터로 구성된다. 
입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다. 
각 테스트 데이터는 한 줄로 구성된다. 각 줄에는 네 개의 정수 M, N, x와 y가 주어진다. 
(1 ≤ M, N ≤ 40,000, 1 ≤ x ≤ M, 1 ≤ y ≤ N) 여기서 <M:N>은 카잉 달력의 마지막 해를 나타낸다.

출력
출력은 표준 출력을 사용한다. 
각 테스트 데이터에 대해, 정수 k를 한 줄에 출력한다. 
여기서 k는 <x:y>가 k번째 해를 나타내는 것을 의미한다. 
만일 <x:y>에 의해 표현되는 해가 없다면, 즉, <x:y>가 유효하지 않은 표현이면, -1을 출력한다.


x는 1부터 M까지, y는 1부터 N까지의 주기를 가지고 각각 따로 증가
해가 몇 번째인지 찾기 위해 x와 y가 동시에 만족하는 해를  출력 


x가 3이라면,
3 (첫 번째 주기)
3 + M (두 번째 주기)
3 + 2M (세 번째 주기)
3 + 3M (네 번째 주기)

M = 10이라면:
3, 13, 23, 33, ... 10씩 증가


y는 1부터 N까지 주기적으로 증가
예를 들어, N = 11이라면:
1번째 해: y = 1
2번째 해: y = 2
...
11번째 해: y = 11
12번째 해: y = 1 (여기서 y가 다시 리셋)
13번째 해: y = 2


N = 11인 경우:
1번째 해: (1 - 1) % 11 + 1 = 0 + 1 = 1
2번째 해: (2 - 1) % 11 + 1 = 1 + 1 = 2
...
11번째 해: (11 - 1) % 11 + 1 = 10 + 1 = 11
12번째 해: (12 - 1) % 11 + 1 = 11 % 11 + 1 = 0 + 1 = 1
*/


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 개수

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            boolean found = false;
            // x가 되는 해들은 x, M + x, 2M + x, ..., 이러한 패턴으로 발생
            for (int k = x; k <= M * N; k += M) {
                // y와 일치하는지 확인
                if ((k - 1) % N + 1 == y) {
                    sb.append(k).append("\n");
                    found = true;
                    break;
                }
            }

            // 해당하는 해를 못 찾았을 경우 -1 출력
            if (!found) {
                sb.append("-1\n");
            }
        }

        System.out.print(sb.toString());
    }
}
