/*
듣도 못한 사람의 수 N (1 <= N <= 500,000 )
보도 못한 사람의 수 M (1 <= M <= 500,000)
이름의 길이: 1 이상 20 이하의 알파벳 소문자로만 구성된 문자열
듣도 못한 사람과 보도 못한 사람의 명단에는 중복되는 이름이 없다.->set

두 집합의 교집합을 구하면 듣도 보도 못한 사람의 명단을 사전순으로 정렬
*/


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 듣도 못한 사람의 명단을 HashSet에 저장
        HashSet<String> unheardSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            unheardSet.add(br.readLine());
        }

        // 듣보잡 명단을 HashSet으로 저장
        HashSet<String> unheardUnseenSet = new HashSet<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (unheardSet.contains(name)) {
                unheardUnseenSet.add(name);
            }
        }

        
        List<String> resultList = new ArrayList<>(unheardUnseenSet);
        // 듣보잡 명단을 사전순으로 정렬
        Collections.sort(resultList);

        StringBuilder sb = new StringBuilder();
        sb.append(resultList.size()).append("\n");
        for (String name : resultList) {
            sb.append(name).append("\n");
        }

        // 결과 출력
        System.out.print(sb.toString());
    }
}
