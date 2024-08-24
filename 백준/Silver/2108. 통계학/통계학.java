import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            sum += numbers[i];
        }
        
        // 1. 산술평균
        double mean = (double) sum / n;
        System.out.println(Math.round(mean));
        
        // 2. 중앙값
        Arrays.sort(numbers);
        int median = numbers[n / 2];
        System.out.println(median);
        
        // 3. 최빈값
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : numbers) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        int maxFrequency = 0;
        for (int freq : frequencyMap.values()) {
            if (freq > maxFrequency) {
                maxFrequency = freq;
            }
        }
        
        ArrayList<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                modes.add(entry.getKey());
            }
        }
        
        Collections.sort(modes);
        int mode = modes.size() > 1 ? modes.get(1) : modes.get(0);
        System.out.println(mode);
        
        // 4. 범위
        int range = numbers[n - 1] - numbers[0];
        System.out.println(range);
    }
}
