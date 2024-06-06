import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 데이터 읽기
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();  // Consume the remaining newline

        // 노래 정보 저장을 위한 맵
        Map<String, List<String>> songMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int T = sc.nextInt();
            String title = sc.next();
            String[] notes = new String[7];
            for (int j = 0; j < 7; j++) {
                notes[j] = sc.next();
            }
            sc.nextLine();  // Consume the remaining newline
            
            String firstThreeNotes = notes[0] + notes[1] + notes[2];
            songMap.putIfAbsent(firstThreeNotes, new ArrayList<>());
            songMap.get(firstThreeNotes).add(title);
        }

        // 맞히기 시도
        for (int i = 0; i < M; i++) {
            String b1 = sc.next();
            String b2 = sc.next();
            String b3 = sc.next();
            sc.nextLine();  // Consume the remaining newline

            String queryNotes = b1 + b2 + b3;

            if (songMap.containsKey(queryNotes)) {
                List<String> titles = songMap.get(queryNotes);
                if (titles.size() == 1) {
                    System.out.println(titles.get(0));
                } else {
                    System.out.println("?");
                }
            } else {
                System.out.println("!");
            }
        }

        sc.close();
    }
}
