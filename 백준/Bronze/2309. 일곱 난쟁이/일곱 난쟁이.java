import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력을 받습니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 아홉 난쟁이의 키를 저장할 배열을 선언합니다.
        int[] dwarfs = new int[9];
        
        // 아홉 난쟁이의 키를 입력받아 배열에 저장합니다.
        for (int i = 0; i < 9; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
        }
        
        // 아홉 난쟁이 키의 합을 계산합니다.
        int totalSum = 0;
        for (int dwarf : dwarfs) {
            totalSum += dwarf;  // 모든 난쟁이의 키를 더합니다.
        }
        
        // 키의 합에서 100을 뺀 값을 구합니다. 이 값은 제거할 두 난쟁이 키의 합입니다.
        int target = totalSum - 100;
        int dwarf1 = -1, dwarf2 = -1;
        boolean found = false;
        
        // 두 난쟁이의 키의 합이 target과 같은지 찾습니다.
        for (int i = 0; i < 8; i++) {  // 첫 번째 난쟁이를 선택하기 위한 루프
            for (int j = i + 1; j < 9; j++) {  // 두 번째 난쟁이를 선택하기 위한 루프
                if (dwarfs[i] + dwarfs[j] == target) {
                    // 두 난쟁이의 키 합이 target과 같으면
                    dwarf1 = i;
                    dwarf2 = j;
                    found = true;  // 두 난쟁이를 찾았음을 표시
                    break;  // 내부 루프를 종료합니다.
                }
            }
            if (found) break;  // 두 난쟁이를 찾았으면 외부 루프도 종료합니다.
        }
        
        // 일곱 난쟁이의 키를 저장할 임시 배열을 선언합니다.
        int[] remainingDwarfs = new int[7];
        int index = 0;

        // 선택된 두 난쟁이를 제외한 나머지 난쟁이의 키를 저장합니다.
        for (int i = 0; i < 9; i++) {
            if (i != dwarf1 && i != dwarf2) {
                remainingDwarfs[index++] = dwarfs[i];
            }
        }

        // 일곱 난쟁이의 키를 오름차순으로 정렬합니다.
        Arrays.sort(remainingDwarfs);

        // 일곱 난쟁이의 키를 출력합니다.
        for (int dwarf : remainingDwarfs) {
            System.out.println(dwarf);
        }
    }
}
