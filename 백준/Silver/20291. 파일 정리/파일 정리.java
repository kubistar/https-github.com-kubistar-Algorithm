
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 파일 갯수 입력받기

        Map<String, Integer> extCount = new TreeMap<>(); // 자동정렬

        for(int i = 0; i < N; i++)
        {
            String filename = br.readLine();
            String extension = filename.substring(filename.lastIndexOf(".") + 1); // 확장자 추출
            extCount.put(extension, extCount.getOrDefault(extension, 0) + 1);
        }

        // 확장자별 개수 출력
        for (Map.Entry<String, Integer> entry : extCount.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}