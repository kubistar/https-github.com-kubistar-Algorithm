import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 끝말잇기 기록의 길이 N 입력
        int N = Integer.parseInt(br.readLine());

        // 끝말잇기 기록 배열
        String[] records = new String[N];

        // 끝말잇기 기록 입력
        for (int i = 0; i < N; i++) {
            records[i] = br.readLine();
        }

        // 후보 단어의 개수 M 입력
        int M = Integer.parseInt(br.readLine());

        // 후보 단어 배열
        String[] candidates = new String[M];

        // 후보 단어 입력
        for (int i = 0; i < M; i++) {
            candidates[i] = br.readLine();
        }

        // '?'의 위치 찾기
        int questionMarkIndex = -1;
        for (int i = 0; i < N; i++) {
            if (records[i].equals("?")) {
                questionMarkIndex = i;
                break;
            }
        }

        // '?' 앞과 뒤 단어의 마지막 글자와 첫 글자 확인
        String prevWord = questionMarkIndex > 0 ? records[questionMarkIndex - 1] : null;
        String nextWord = questionMarkIndex < N - 1 ? records[questionMarkIndex + 1] : null;
        char prevLastChar = prevWord != null ? prevWord.charAt(prevWord.length() - 1) : ' ';
        char nextFirstChar = nextWord != null ? nextWord.charAt(0) : ' ';

        // 기존 기록에 있는 단어들을 Set에 저장
        Set<String> existingWords = new HashSet<>();
        for (String record : records) {
            if (!record.equals("?")) {
                existingWords.add(record);
            }
        }

        // 후보 단어들 중 조건에 맞는 단어 찾기
        for (String candidate : candidates) {
            char candidateFirstChar = candidate.charAt(0);
            char candidateLastChar = candidate.charAt(candidate.length() - 1);

            // 후보 단어가 기존 기록에 없고 조건을 만족하는지 확인
            if (!existingWords.contains(candidate) &&
                (prevWord == null || prevLastChar == candidateFirstChar) &&
                (nextWord == null || candidateLastChar == nextFirstChar)) {
                // 조건을 만족하는 단어 출력
                System.out.println(candidate);
                break;
            }
        }
    }
}
