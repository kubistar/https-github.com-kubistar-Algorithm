import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받기
        String input = br.readLine().toUpperCase();

        // 알파벳 빈도 배열
        int[] frequency = new int[26];

        // 각 문자의 빈도를 계산
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            frequency[c - 'A']++;
        }

        // 가장 많이 사용된 알파벳 찾기
        int maxFrequency = 0;
        char mostFrequentChar = '?';
        boolean isDuplicate = false;

        for (int i = 0; i < 26; i++) {
            if (frequency[i] > maxFrequency) {
                maxFrequency = frequency[i];
                mostFrequentChar = (char) (i + 'A');
                isDuplicate = false;
            } else if (frequency[i] == maxFrequency) {
                isDuplicate = true;
            }
        }

        // 결과 출력
        System.out.println(isDuplicate ? "?" : mostFrequentChar);
    }
}
