import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    /*문제
    과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다. 주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오.

            입력
    입력은 여러개의 테스트케이스로 주어지며 마지막줄에는 0 0 0이 입력된다. 각 테스트케이스는 모두 30,000보다 작은 양의 정수로 주어지며, 각 입력은 변의 길이를 의미한다.

            출력
    각 입력에 대해 직각 삼각형이 맞다면 "right", 아니라면 "wrong"을 출력한다.

    예제 입력 1
            6 8 10
            25 52 60
            5 12 13
            0 0 0
    예제 출력 1
    right
            wrong
    right*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line; // 각 줄의 입력을 저장할 변수

        // 입력의 각 줄을 처리하는 반복문
        while ((line = br.readLine()) != null) {
            // 한 줄의 입력을 공백을 기준으로 분리하여 문자열 배열로 변환
            String[] input = line.split(" ");

            // 분리된 문자열을 정수로 변환
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            // 입력이 "0 0 0"인 경우 반복을 종료
            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            // 세 변의 길이를 배열에 저장
            int[] sides = {a, b, c};
            // 배열을 정렬하여 가장 긴 변이 마지막에 오도록 함
            Arrays.sort(sides);
            // 정렬된 배열에서 각 변의 길이를 꺼냄
            int x = sides[0];
            int y = sides[1];
            int z = sides[2];

            // 피타고라스 정리를 이용하여 직각삼각형 여부를 확인
            if (x * x + y * y == z * z) {
                // 조건이 만족하면 "right" 출력
                System.out.println("right");
            } else {
                // 조건이 만족하지 않으면 "wrong" 출력
                System.out.println("wrong");
            }
        }

    }
}
