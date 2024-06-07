import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] dwarfs = new int[9];
        for (int i = 0; i < 9; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
        }
        
        int totalSum = 0;
        for (int dwarf : dwarfs) {
            totalSum += dwarf;
        }
        
        int target = totalSum - 100;
        int dwarf1 = 0, dwarf2 = 0;
        boolean found = false;
        
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (dwarfs[i] + dwarfs[j] == target) {
                    dwarf1 = dwarfs[i];
                    dwarf2 = dwarfs[j];
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        
        int[] remainingDwarfs = new int[7];
        int index = 0;
        for (int dwarf : dwarfs) {
            if (dwarf != dwarf1 && dwarf != dwarf2) {
                remainingDwarfs[index++] = dwarf;
            }
        }
        
        Arrays.sort(remainingDwarfs);
        for (int dwarf : remainingDwarfs) {
            System.out.println(dwarf);
        }
    }
}
