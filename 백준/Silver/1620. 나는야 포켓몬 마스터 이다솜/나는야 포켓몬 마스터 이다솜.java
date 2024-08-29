/*
입력
포켓몬의 총 개수 N, 문제의 총 개수 M
둘째 줄부터 N개의 줄에 포켓몬의 이름이 순서대로 주어짐. 
그 다음 줄부터 M개의 줄에 문제

출력
각 문제에 대해, 숫자면 해당 번호에 해당하는 포켓몬 이름을, 포켓몬 이름이면 그 포켓몬의 번호를 출력
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 포켓몬 이름을 키로, 번호를 값으로 하는 HashMap
        HashMap<String, Integer> nameToNumber = new HashMap<>();
        // 번호를 인덱스로, 포켓몬 이름을 값으로 하는 ArrayList
        ArrayList<String> numberToName = new ArrayList<>(N + 1);

        // ArrayList의 0번째 인덱스를 채우기 위해 미리 넣어줌 (0번 인덱스는 사용하지 않음)
        numberToName.add("");

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            nameToNumber.put(name, i);
            numberToName.add(name);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String query = br.readLine();

            // 숫자인지 문자인지 확인
            if (Character.isDigit(query.charAt(0))) {
                // 숫자인 경우, 해당 번호의 포켓몬 이름 출력
                int num = Integer.parseInt(query);
                sb.append(numberToName.get(num)).append("\n");
            } else {
                // 문자인 경우, 해당 포켓몬 이름의 번호 출력
                sb.append(nameToNumber.get(query)).append("\n");
            }
        }

        // 결과 한꺼번에 출력
        System.out.print(sb.toString());
    }
}
