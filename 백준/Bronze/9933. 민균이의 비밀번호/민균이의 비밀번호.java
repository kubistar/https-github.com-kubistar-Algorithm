import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashSet<String> words = new HashSet<>();

        // Read all words and store them in a set
        for (int i = 0; i < n; i++) {
            String word = br.readLine().trim();
            words.add(word);
        }

        // Find the password
        for (String word : words) {
            String reversedWord = new StringBuilder(word).reverse().toString();
            if (words.contains(reversedWord)) {
                int length = word.length();
                char middleChar = word.charAt(length / 2);
                System.out.println(length + " " + middleChar);
                break;
            }
        }

        br.close();
    }
}
