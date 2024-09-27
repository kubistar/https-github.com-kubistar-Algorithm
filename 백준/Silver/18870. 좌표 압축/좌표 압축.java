import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N (좌표의 개수)
        int N = Integer.parseInt(br.readLine());
        
        // 공백으로 구분된 N개의 좌표
        int[] coordinates = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for (int i = 0; i < N; i++) {
            coordinates[i] = Integer.parseInt(st.nextToken());
        }
        
        // 원본 배열을 복사해서 정렬된 배열을 만든다
        int[] sortedCoordinates = coordinates.clone();
        Arrays.sort(sortedCoordinates);
        
        // 중복을 제거하고 좌표 압축을 위해 HashMap을 사용한다
        HashMap<Integer, Integer> coordinateMap = new HashMap<>();
        int index = 0;
        
        for (int value : sortedCoordinates) {
            if (!coordinateMap.containsKey(value)) {
                coordinateMap.put(value, index++);
            }
        }
        
        // 원래 배열을 압축된 좌표로 변환해서 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(coordinateMap.get(coordinates[i])).append(" ");
        }
        
        // 결과 출력
        System.out.println(sb.toString().trim());
    }
}
