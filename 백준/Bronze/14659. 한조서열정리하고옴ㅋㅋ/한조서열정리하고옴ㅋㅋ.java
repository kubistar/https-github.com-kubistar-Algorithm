import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] heights = new int[n];
        
        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }
        
        int maxEnemies = 0;
        int currentMaxHeight = heights[0];
        int currentEnemies = 0;
        
        for (int i = 1; i < n; i++) {
            if (heights[i] < currentMaxHeight) {
                currentEnemies++;
            } else {
                maxEnemies = Math.max(maxEnemies, currentEnemies);
                currentEnemies = 0;
                currentMaxHeight = heights[i];
            }
        }
        
        maxEnemies = Math.max(maxEnemies, currentEnemies);
        
        System.out.println(maxEnemies);
    }
}
