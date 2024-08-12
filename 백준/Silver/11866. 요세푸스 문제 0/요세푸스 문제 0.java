import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        
        List<Integer> people = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            people.add(i);
        }
        
        StringBuilder result = new StringBuilder();
        result.append("<");
        
        int index = 0;
        while (people.size() > 0) {
            index = (index + K - 1) % people.size();
            result.append(people.remove(index));
            if (people.size() > 0) {
                result.append(", ");
            }
        }
        
        result.append(">");
        System.out.println(result.toString());
    }
}
