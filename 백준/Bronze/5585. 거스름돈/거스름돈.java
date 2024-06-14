import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 입력
        int paidAmount = scanner.nextInt();
        
        // 잔돈의 개수 출력
        System.out.println(countCoins(paidAmount));
        
        scanner.close();
    }
    
    public static int countCoins(int paidAmount) {
        int change = 1000 - paidAmount;
        int[] coins = {500, 100, 50, 10, 5, 1};
        int coinCount = 0;
        
        for (int coin : coins) {
            coinCount += change / coin;
            change %= coin;
        }
        
        return coinCount;
    }
}
