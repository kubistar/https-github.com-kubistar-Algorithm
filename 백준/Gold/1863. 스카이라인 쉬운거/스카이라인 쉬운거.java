import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] coordinates = new int[n][2];

        // 좌표 입력 받기
        for (int i = 0; i < n; i++) {
            coordinates[i][0] = scanner.nextInt();
            coordinates[i][1] = scanner.nextInt();
        }

        System.out.println(countBuildings(coordinates));
    }

    public static int countBuildings(int[][] coordinates) {
        Stack<Integer> heights = new Stack<>();
        int buildings = 0;

        // 첫 번째 지점은 높이가 0
        heights.push(0);

        for (int i = 0; i < coordinates.length; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];

            // 현재 높이보다 더 낮은 높이가 나올 때까지 pop
            while (heights.peek() > y) {
                heights.pop();
                buildings++; // 건물의 수 증가
            }

            // 높이가 증가하면 스택에 추가
            if (heights.peek() < y) {
                heights.push(y);
            }
        }

        // 스택에 남아있는 높이들은 단독 건물을 의미하므로 건물의 수에 더함
        buildings += heights.size() - 1;

        return buildings;
    }
}
