import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine());
        int[] shops = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            shops[i] = Integer.parseInt(st.nextToken());
        }

        // 최대 마실 수 있는 우유 개수 계산
        System.out.println(maxMilk(N, shops));
    }

    public static int maxMilk(int N, int[] shops) {
        int currentMilk = 0;  // 현재 마셔야 할 우유 종류 (0: 딸기, 1: 초코, 2: 바나나)
        int count = 0;

        for (int shop : shops) {
            if (shop == currentMilk) {
                count++;
                currentMilk = (currentMilk + 1) % 3;  // 다음 우유로 변경
            }
        }

        return count;
    }
}
