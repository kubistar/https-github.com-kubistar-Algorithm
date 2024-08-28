/*
연산의 수 M (1 ≤ M ≤ 3,000,000)
둘째 줄부터 M개의 줄에 수행해야 하는 연산이 한 줄에 하나씩 주어짐
각 연산은 add x, remove x, check x, toggle x, all, empty 중 하나

*/



import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();  
        
        int M = Integer.parseInt(br.readLine());  // 연산의 수 
        HashSet<Integer> set = new HashSet<>();  

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int x;

            switch (command) {
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    set.add(x);  // HashSet에 x 추가
                    break;

                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    set.remove(x);  // HashSet에서 x 제거
                    break;

                case "check":
                    x = Integer.parseInt(st.nextToken());
                    if (set.contains(x)) {  // HashSet에 x가 있는지 확인
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;

                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    if (set.contains(x)) {  // HashSet에 x가 있으면 제거
                        set.remove(x);
                    } else {  // 없으면 추가
                        set.add(x);
                    }
                    break;

                case "all":
                    set.clear();  // 기존 집합을 비우고
                    for (int j = 1; j <= 20; j++) {
                        set.add(j);  // 1부터 20까지 추가
                    }
                    break;

                case "empty":
                    set.clear();  // HashSet을 비워서 공집합으로 만듬
                    break;
            }
        }

        System.out.print(sb.toString());  // 모든 출력을 한 번에 처리
        br.close();
    }
}
