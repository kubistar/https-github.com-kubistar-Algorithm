import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine()); // 주의 개수
		
		Map<String, Integer> map = new LinkedHashMap<>();
		List<Integer> list;
		StringTokenizer st;
		String name;
		
		// 주의 개수만큼 반복
		while (n-- > 0) {
			
			// 한 주에 4개의 시간 타임
			for (int i = 1; i <= 4; i++) {
				st = new StringTokenizer(br.readLine());
				
				// 한 주에 7일
				for (int j = 0; j < 7; j++) {
					name = st.nextToken();
					
					// 근무자가 없다면
					if (name.equals("-")) {
						continue;
					}
					
					// 근무자가 있지만 처음 근무한다면 생성
					if (!map.containsKey(name)) {
						map.put(name, 0);
					}
					
					// 근무 시간 추가
					map.put(name, map.get(name) + time(i));
				}
			}
		}
		
		// 근무자가 1명도 없었다면
		if (map.size() == 0) {
			sb.append("Yes");
		} else {
			list = new ArrayList<>(map.values());
			Collections.sort(list);
			
			// 제일 큰값에서 제일 작은 값을 뺏을 때 12시간을 초과한다면
			if (list.get(list.size() - 1) - list.get(0) > 12) {
				sb.append("No");
			} else {
				sb.append("Yes");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	// 시간 타임마다 근무 시간이 다르기 때문에 근무 시간을 찾아주는 함수.
	private static int time(int t) {
		if (t == 1 || t == 3) {
			return 4;
		} else if (t == 2) {
			return 6;
		} else {
			return 10;
		}
	}
}
//출처: https://steadycoding-turtleman.tistory.com/entry/BEAKJOON-백준-JAVA-25593번-근무-지옥에-빠진-푸앙이-Small [SlowCoding:티스토리]