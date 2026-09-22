import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
        int[] dx = new int[128];
        int[] dy = new int[128];
        dx['U'] = 0; dy['U'] = 1;
        dx['D'] = 0; dy['D'] = -1;
        dx['R'] = 1; dy['R'] = 0;
        dx['L'] = -1; dy['L'] = 0;

        Set<String> visited = new HashSet<>();
        int x = 0, y = 0;

        for (char c : dirs.toCharArray()) {
            int nx = x + dx[c];
            int ny = y + dy[c];

            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;

            String path1 = x + "," + y + "->" + nx + "," + ny;
            String path2 = nx + "," + ny + "->" + x + "," + y;
            visited.add(path1);
            visited.add(path2);

            x = nx;
            y = ny;
        }

        return visited.size() / 2;
    }
}