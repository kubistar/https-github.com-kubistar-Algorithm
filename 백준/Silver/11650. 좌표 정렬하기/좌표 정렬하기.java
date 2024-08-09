/*
주어진 2차원 평면 위의 점들을 특정 기준에 따라 정렬한 후 출력하는 프로그램

입력 조건:
첫 번째 줄에는 점의 개수 N (1 ≤ N ≤ 100,000)
그 다음 N개의 줄에는 각 점의 x좌표 xi와 y좌표 yi가 주어집니다. (-100,000 ≤ xi, yi ≤ 100,000)
좌표는 항상 정수
위치가 같은 두 점은 없다

주어진 점들을 x좌표가 증가하는 순서로 정렬
만약 x좌표가 같다면 y좌표가 증가하는 순서로 정렬
정렬된 결과를 출력
*/


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
        
        // 정렬: x좌표 기준 오름차순, x좌표가 같다면 y좌표 기준 오름차순
        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.x == p2.x) {
                    return Integer.compare(p1.y, p2.y); // y좌표 오름차순
                } else {
                    return Integer.compare(p1.x, p2.x); // x좌표 오름차순
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

