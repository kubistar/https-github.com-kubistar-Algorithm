import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] words = new String[5];
        for (int i = 0; i < 5; i++) {
            words[i] = reader.readLine();
        }

        StringBuilder result = new StringBuilder();
        
        for (int col = 0; col < 15; col++) {
            for (int row = 0; row < 5; row++) {
                if (col < words[row].length()) {
                    result.append(words[row].charAt(col));
                }
            }
        }

        System.out.println(result.toString());
    }
}
