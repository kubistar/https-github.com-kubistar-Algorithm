/*
온라인 저지에 가입한 사람들의 정보를 나이 순으로 정렬하는 프로그램을 작성

첫 줄에 주어지는 N은 온라인 저지에 가입한 회원의 수 (1 ≤ N ≤ 100,000)
이후 N개의 줄에 각 회원의 나이와 이름이 공백으로 구분
나이는 1 이상, 200 미만의 정수이고, 이름은 알파벳 대소문자로 이루어져 있으며 길이는 100자 이하
출력 조건:
주어진 회원들을 "나이 순"으로 정렬해서 출력
만약 두 사람의 나이가 같다면, "가입한 순서"대로 정렬
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

// Member 클래스를 정의하여 나이, 이름, 가입 순서(order)를 저장
class Member {
    int age;
    String name;
    int order;

    // 생성자를 통해 Member 객체를 초기화
    Member(int age, String name, int order) {
        this.age = age;
        this.name = name;
        this.order = order;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄에서 회원의 수 N을 입력받음
        int N = Integer.parseInt(br.readLine());
        
        // 회원 정보를 저장할 ArrayList를 생성
        ArrayList<Member> members = new ArrayList<>();
        
        // N번 반복하여 각 회원의 나이와 이름을 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken()); // 나이 입력
            String name = st.nextToken(); // 이름 입력
            members.add(new Member(age, name, i)); // Member 객체를 생성하여 리스트에 추가
        }
        
        // 회원들을 정렬합니다. Comparator를 사용하여 정렬 기준을 설정
        Collections.sort(members, new Comparator<Member>() {
            @Override
            public int compare(Member m1, Member m2) {
                // 첫 번째 기준: 나이 비교 (오름차순)
                if (m1.age == m2.age) {
                    // 두 번째 기준: 나이가 같다면 입력된 순서(order)로 정렬 (오름차순)
                    return Integer.compare(m1.order, m2.order);
                } else {
                    // 나이가 다르면 나이 순으로 정렬 (오름차순)
                    return Integer.compare(m1.age, m2.age);
                }
            }
        });
        
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (Member member : members) {
            // 각 회원의 나이와 이름을 StringBuilder에 추가
            sb.append(member.age).append(" ").append(member.name).append("\n");
        }
        
        // 모든 회원 정보를 출력
        System.out.print(sb.toString());
    }
}
