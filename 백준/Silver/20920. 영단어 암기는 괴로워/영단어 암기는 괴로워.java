/*
N: 주어진 단어의 개수 (1 ≤ 𝑁 ≤100,000).
𝑀: 단어의 길이 기준 (1≤M≤10).
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 주어진 단어 갯수
        int M = Integer.parseInt(st.nextToken());  //  단어길이
        
        // 단어 입력 받기
        Map<String, Integer> wordCounts = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine().trim();
            if (word.length() >= M) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }
        
        // 단어 정렬
        List<String> sortedWords = new ArrayList<>(wordCounts.keySet());
        sortedWords.sort((w1, w2) -> {
            // 빈도수 내림차순
            int freqCompare = Integer.compare(wordCounts.get(w2), wordCounts.get(w1));
            if (freqCompare != 0) return freqCompare;
            // 길이 내림차순
            int lengthCompare = Integer.compare(w2.length(), w1.length());
            if (lengthCompare != 0) return lengthCompare;
            // 사전순 오름차순
            return w1.compareTo(w2);
        });

        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String word : sortedWords) {
            bw.write(word);
            bw.newLine();
        }
        bw.flush();
    }
}
