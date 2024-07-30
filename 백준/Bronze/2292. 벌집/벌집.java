import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
*       1번째 층: 방 1 (중앙)
        2번째 층: 방 2 ~ 방 7 (6개)
        3번째 층: 방 8 ~ 방 19 (12개)
        4번째 층: 방 20 ~ 방 37 (18개)
        ...
        즉, 각 층의 방 개수는 6의 배수로 증가
        특정 방 𝑁까지 가는 경로의 최소 방 개수를 구하려면 𝑁이 어느 층에 있는지를 파악해야 함

        초기 층을 1로 시작
        각 층마다 그 층의 최대 방 번호를 계산
        방 번호𝑁이 해당 층의 최대 방 번호보다 작거나 같으면 현재 층이 최소 경로.
        그렇지 않으면 다음 층으로 이동
*
* */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 방번호 입력받기
        int N = Integer.parseInt(br.readLine());


        // 만약 N이 1이라면, 중앙 방이므로 바로 1을 출력하고 프로그램을 종료
        if (N == 1) {
            System.out.println(1);
            return;
        }

        int layer = 1;  // 초기 층
        int maxRoomNumberInLayer = 1;     //   해당 층의 최대 방 번호

        // 현재 층의 최대 방 번호가 N보다 작으면, 층을 하나씩 증가시키면서 최대 방 번호를 갱신
        while (maxRoomNumberInLayer < N) {
            maxRoomNumberInLayer += 6 * layer;   //각 층마다 6개의 방이 추가
            layer++;
        }

        System.out.println(layer);
    }
}