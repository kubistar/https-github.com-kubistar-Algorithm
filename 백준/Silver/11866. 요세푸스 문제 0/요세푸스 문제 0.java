// 원순열

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받기 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 한 줄을 읽어와서 공백을 기준으로 분리하여 N과 K 값으로 저장
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 총 사람의 수
        int K = Integer.parseInt(input[1]); // 제거할 사람의 순번
        
        // 사람들의 리스트를 저장할 LinkedList 생성 (1번부터 N번까지의 사람들)
        List<Integer> people = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            people.add(i); // 리스트에 1부터 N까지의 숫자 추가
        }
        
        // 결과를 저장할 StringBuilder 사용
        StringBuilder result = new StringBuilder();
        result.append("<"); // 요세푸스 순열의 시작을 표시
        
        int index = 0; // 현재 제거할 사람의 인덱스 초기화
        while (people.size() > 0) { // 리스트에 사람이 남아있는 동안 반복
            // K번째 사람을 찾기 위한 인덱스 계산
            index = (index + K - 1) % people.size();
            // 해당 인덱스의 사람을 리스트에서 제거하고 결과에 추가
            result.append(people.remove(index));
            // 만약 아직 사람이 남아있다면, ", "를 결과에 추가
            if (people.size() > 0) {
                result.append(", ");
            }
        }
        
        result.append(">"); // 요세푸스 순열의 끝을 표시
        System.out.println(result.toString()); // 결과 출력
    }
}
