import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 단어의 개수 입력받기
        int n = Integer.parseInt(br.readLine());
        
        // 중복을 제거하기 위해 HashSet 사용
        Set<String> wordSet = new HashSet<>();
        
        // 단어 입력 받기
        for (int i = 0; i < n; i++) {
            wordSet.add(br.readLine().trim());
        }
        
        // Set을 List로 변환 후 정렬
        List<String> wordList = new ArrayList<>(wordSet);
        
        // 정렬: 길이가 짧은 순으로, 길이가 같으면 사전 순으로
        wordList.sort((word1, word2) -> {
            if (word1.length() != word2.length()) {
                return word1.length() - word2.length(); // 길이가 짧은 순으로 정렬
            } else {
                return word1.compareTo(word2); // 길이가 같으면 사전 순으로 정렬
            }
        });
        
        // StringBuilder를 사용하여 출력 최적화
        StringBuilder sb = new StringBuilder();
        for (String word : wordList) {
            sb.append(word).append('\n'); // 각 단어를 추가하고 줄 바꿈 추가
        }
        
        // StringBuilder에 모아둔 결과를 한 번에 출력
        System.out.print(sb.toString());
    }
}
