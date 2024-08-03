import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


/*
666
1666
2666
3666
4666
5666
6660
6661
...
166699
*/

public class Main {
    public static void main(String[] args) throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N값 입력 받기
        int N = Integer.parseInt(br.readLine());
        
        // count: 종말의 수를 센다.
        // number: 현재 숫자
        int count = 0;
        int number = 666;
        
        while (true) {
            // 현재 숫자를 문자열로 변환하고 "666"이 포함되어 있는지 확인
            if (String.valueOf(number).contains("666")) {
                count++;
                if (count == N) {
                    // N번째 종말의 수를 찾았으면 출력하고 종료
                    System.out.println(number);
                    break;
                }
            }
            // 다음 숫자 확인
            number++;
        }
    }
}
