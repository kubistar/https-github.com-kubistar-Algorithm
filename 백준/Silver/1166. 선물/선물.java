import java.io.*;
import java.util.*;
 
public class Main {
   public static void main(String[] args) throws IOException {
      StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
      int N = Integer.parseInt(st.nextToken()); // 넣어야 할 정육면체 박스의 개수
      int L = Integer.parseInt(st.nextToken()); // 큰 직육면체 박스의 길이
      int W = Integer.parseInt(st.nextToken()); // 큰 직육면체 박스의 너비
      int H = Integer.parseInt(st.nextToken()); // 큰 직육면체 박스의 높이
 
      // 이진 탐색 범위 초기화
      double low = 0; // 정육면체 한 변의 최소 크기
      double high = Math.min(L, Math.min(W, H));  //가로, 세로, 높이 중에서 가장 긴 변의 길이를 탐색 끝으로 잡는다.
      double mid; // 탐색 중간값
 
      // 이진 탐색 
      while (low < high) {
         // 현재 탐색하려는 A의 길이를 설정
         mid = (low + high) / 2;
 
         // 현재 mid 크기의 정육면체가 큰 박스에 들어가는 총 개수를 계산
         // (각 차원의 박스 개수는 floor(L/mid), floor(W/mid), floor(H/mid)로 계산 가능)
         if ((long)(L / mid) * (long)(W / mid) * (long)(H / mid) < N) {
            // 박스가 N개보다 적게 들어가므로 mid 크기가 너무 큼 -> high를 줄임
            if (high == mid) break; // 무한 루프 방지: high와 mid가 같아지면 종료
            high = mid;
         } else {
            // 박스가 N개 이상 들어가므로 mid 크기가 가능 -> low를 늘림
            if (low == mid) break; // 무한 루프 방지: low와 mid가 같아지면 종료
            low = mid;
         }
      }
 
      // 가능한 정육면체의 최대 크기 
      System.out.println(low);
   }
}
