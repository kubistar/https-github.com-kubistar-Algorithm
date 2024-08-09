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

class Member {
    int age;
    String name;
    int order;

    Member(int age, String name, int order) {
        this.age = age;
        this.name = name;
        this.order = order;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        ArrayList<Member> members = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members.add(new Member(age, name, i));
        }
        
        // 나이 기준으로 먼저 정렬하고, 나이가 같다면 order(입력 순서)로 정렬
        Collections.sort(members, new Comparator<Member>() {
            @Override
            public int compare(Member m1, Member m2) {
                if (m1.age == m2.age) {
                    return Integer.compare(m1.order, m2.order);
                } else {
                    return Integer.compare(m1.age, m2.age);
                }
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for (Member member : members) {
            sb.append(member.age).append(" ").append(member.name).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}

