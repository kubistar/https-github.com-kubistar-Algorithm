import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        List<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < n / 2; i++) {
            ans.add(1);
            ans.add(2);
        }
        
        if (n % 2 == 1) {
            ans.add(3);
        }
        
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i));
            if (i < ans.size() - 1) {
                System.out.print(" ");
            }
        }
    }
}
