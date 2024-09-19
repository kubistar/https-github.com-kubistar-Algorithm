/*
괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램

입력
첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 
가장 처음과 마지막 문자는 숫자이다. 그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 
5자리보다 많이 연속되는 숫자는 없다. 
수는 0으로 시작할 수 있다. 입력으로 주어지는 식의 길이는 50보다 작거나 같다.

출력
첫째 줄에 정답을 출력한다.

주어진 식에서 '-'를 기준으로 한 번 나누면 그 이후의 모든 '+' 연산은 음수로 처리될 수 있다. 
"-" 이후에 나오는 모든 숫자들을 최대한 묶어서 음수로 만들어야 합
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력받은 수식
        String expression = br.readLine();
        
        // 수식을 '-' 기준으로 분리
        // '-'가 나오기 전까지는 모두 더하고, 그 이후는 모두 묶어서 빼주면 됨
        String[] parts = expression.split("-");
        
        // 첫 번째 '-'가 나오기 전까지의 부분을 먼저 처리
        // '+'로 연결된 숫자들을 모두 더함
        int total = sumOfParts(parts[0]);
        
        // 두 번째 '-'부터 이후의 부분은 빼주어야 함
        // '-'로 나누어진 나머지 부분들은 각각 더한 후 total에서 차감
        for (int i = 1; i < parts.length; i++) {
            total -= sumOfParts(parts[i]);
        }
        
        // 결과 출력
        System.out.println(total);
    }
    
    // '+'로 구분된 부분을 처리하여 그 합을 계산하는 함수
    // 예를 들어 "50+40"이면 50과 40을 더해서 90을 반환
    private static int sumOfParts(String part) {
        // '+'로 나누어 개별 숫자를 배열로 만듦
        String[] numbers = part.split("\\+");
        int sum = 0;
        
        // 나누어진 각 숫자들을 더함
        for (String number : numbers) {
            sum += Integer.parseInt(number); // 문자열을 정수로 변환하여 더함
        }
        
        return sum; // 각 숫자의 합을 반환
    }
}
