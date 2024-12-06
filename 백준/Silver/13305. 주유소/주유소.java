/*
입력
표준 입력으로 다음 정보가 주어진다. 
첫 번째 줄에는 도시의 개수를 나타내는 정수 N(2 ≤ N ≤ 100,000)이 주어진다. 
다음 줄에는 인접한 두 도시를 연결하는 도로의 길이가 제일 왼쪽 도로부터 N-1개의 자연수로 주어진다.
다음 줄에는 주유소의 리터당 가격이 제일 왼쪽 도시부터 순서대로 N개의 자연수로 주어진다. 
제일 왼쪽 도시부터 제일 오른쪽 도시까지의 거리는 1이상 1,000,000,000 이하의 자연수이다. 
리터당 가격은 1 이상 1,000,000,000 이하의 자연수이다. 

출력
표준 출력으로 제일 왼쪽 도시에서 제일 오른쪽 도시로 가는 최소 비용을 출력


*/


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 도시의 개수 입력
        int n = Integer.parseInt(br.readLine());
        
        // 도로 길이 입력
        long[] roadLengths = new long[n - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            roadLengths[i] = Long.parseLong(st.nextToken());
        }
        
        //주유소 리터당 가격 입력
        long[] prices = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            prices[i] = Long.parseLong(st.nextToken());
        }
        
        // 최소 비용 계산
        long totalCost = 0;
        long minPrice = prices[0]; // 초기 최소 기름 가격
        
        for (int i = 0; i < n - 1; i++) {
            // 현재 도로의 비용 계산
            totalCost += minPrice * roadLengths[i];
            
            // 다음 도시의 가격이 더 저렴하면 갱신
            if (prices[i + 1] < minPrice) {
                minPrice = prices[i + 1];
            }
        }
        
        // 결과 출력
        System.out.println(totalCost);
    }
}
