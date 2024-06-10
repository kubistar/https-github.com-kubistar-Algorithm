import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 입력 처리
        int n = scanner.nextInt();
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int m = scanner.nextInt();
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        
        // 촌수 계산
        int result = findKinship(graph, start, end);
        System.out.println(result);
        
        scanner.close();
    }

    public static int findKinship(Map<Integer, List<Integer>> graph, int start, int end) {
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.add(new int[]{start, 0});
        visited.add(start);
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int person = current[0];
            int distance = current[1];
            
            if (person == end) {
                return distance;
            }
            
            for (int neighbor : graph.get(person)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(new int[]{neighbor, distance + 1});
                }
            }
        }
        
        return -1;
    }
}