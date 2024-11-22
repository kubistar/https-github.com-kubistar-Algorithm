import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 후보자 수
        int daseom = Integer.parseInt(br.readLine()); // 다솜이의 표
        List<Integer> others = new ArrayList<>(); // 다른 후보들의 표

        // 나머지 후보들의 표 입력
        for (int i = 1; i < N; i++) {
            others.add(Integer.parseInt(br.readLine()));
        }

        // 매수 횟수 카운트
        int count = 0;

        // 가장 많은 표를 가진 후보부터 매수
        while (!others.isEmpty() && Collections.max(others) >= daseom) {
            // 가장 큰 표를 가진 후보 찾기
            int maxIndex = others.indexOf(Collections.max(others));
            
            // 매수: 다솜이의 표 증가, 상대 후보 표 감소
            daseom++;
            others.set(maxIndex, others.get(maxIndex) - 1);
            count++;
        }

        // 결과 출력
        System.out.println(count);
    }
}
