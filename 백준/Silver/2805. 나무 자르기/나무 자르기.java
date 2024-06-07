import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.println(findMaxHeight(trees, M));
    }
    
    public static long getWoodLength(int[] trees, int height) {
        long sum = 0;
        for (int tree : trees) {
            if (tree > height) {
                sum += tree - height;
            }
        }
        return sum;
    }
    
    public static int findMaxHeight(int[] trees, int M) {
        int left = 0;
        int right = 0;
        
        for (int tree : trees) {
            if (tree > right) {
                right = tree;
            }
        }
        
        int result = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            long wood = getWoodLength(trees, mid);
            
            if (wood >= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
}
