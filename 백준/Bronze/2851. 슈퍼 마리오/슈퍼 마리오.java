import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] mushroomScores = new int[10];
        for (int i = 0; i < 10; i++) {
            mushroomScores[i] = Integer.parseInt(br.readLine().trim());
        }
        
        int currentSum = 0;
        int closestSum = 0;

        for (int i = 0; i < 10; i++) {
            currentSum += mushroomScores[i];
            if (currentSum >= 100) {
                if (Math.abs(100 - currentSum) < Math.abs(100 - closestSum)) {
                    closestSum = currentSum;
                } else if (Math.abs(100 - currentSum) == Math.abs(100 - closestSum)) {
                    closestSum = Math.max(currentSum, closestSum);
                }
                break;
            }
            closestSum = currentSum;
        }

        System.out.println(closestSum);
    }
}
