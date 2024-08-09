import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

// Point 클래스 정의
class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); // 점의 개수 입력받기
        ArrayList<Point> points = new ArrayList<>(); // 점을 저장할 ArrayList
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // x 좌표
            int y = Integer.parseInt(st.nextToken()); // y 좌표
            points.add(new Point(x, y)); // Point 객체 생성 후 리스트에 추가
        }
        
        // 정렬: y좌표 기준 오름차순, y좌표가 같다면 x좌표 기준 오름차순
        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.y == p2.y) {
                    return Integer.compare(p1.x, p2.x); // x좌표 오름차순
                } else {
                    return Integer.compare(p1.y, p2.y); // y좌표 오름차순
                }
            }
        });
        
        // 정렬된 결과 출력
        StringBuilder sb = new StringBuilder();
        for (Point p : points) {
            sb.append(p.x).append(" ").append(p.y).append("\n");
        }
        System.out.print(sb.toString());
    }
}
