/*
입력
첫째 줄에 테스트 케이스가 주어진다. 테스트 케이스는 최대 100이다.

각 테스트 케이스의 첫째 줄에는 해빈이가 가진 의상의 수 n(0 ≤ n ≤ 30)
다음 n개에는 해빈이가 가진 의상의 이름과 의상의 종류가 공백으로 구분되어 주어진다. 
같은 종류의 의상은 하나만 입을 수 있다.
모든 문자열은 1이상 20이하의 알파벳 소문자로 이루어져있으며 같은 이름을 가진 의상은 존재하지 않는다.

출력
각 테스트 케이스에 대해 해빈이가 알몸이 아닌 상태로 의상을 입을 수 있는 경우의 수
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 입력 받기
        
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine()); // 의상의 수 입력 받기
            HashMap<String, Integer> clothes = new HashMap<>();
            
            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");
                String name = input[0];
                String kind = input[1];
                
                // 의상의 종류별로 개수를 세어 저장
                clothes.put(kind, clothes.getOrDefault(kind, 0) + 1);
            }
            
            int result = 1;
            // 경우의 수 계산 (해당 종류를 안 입는 경우 포함하여 +1)
            for (int count : clothes.values()) {
                result *= (count + 1);
            }
            
            // 아무것도 입지 않은 경우는 제외
            System.out.println(result - 1);
        }
    }
}

