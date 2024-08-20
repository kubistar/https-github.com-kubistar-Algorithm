import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 첫 번째 줄: 상근이의 숫자 카드 개수
        int N = Integer.parseInt(br.readLine());
        
        // 두 번째 줄: 상근이가 가지고 있는 숫자 카드
        String[] cardsInput = br.readLine().split(" ");
        
        // 각 숫자 카드의 개수를 세기
        HashMap<Integer, Integer> cardCount = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(cardsInput[i]);
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }
        
        // 세 번째 줄: 구해야 할 숫자 개수
        int M = Integer.parseInt(br.readLine());
        
        // 네 번째 줄: 구해야 할 숫자들
        String[] targetsInput = br.readLine().split(" ");
        
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(targetsInput[i]);
            // HashMap에서 해당 숫자의 개수를 찾아 결과에 추가
            sb.append(cardCount.getOrDefault(target, 0)).append(" ");
        }
        
        // 결과 출력
        System.out.println(sb.toString().trim());
    }
}
