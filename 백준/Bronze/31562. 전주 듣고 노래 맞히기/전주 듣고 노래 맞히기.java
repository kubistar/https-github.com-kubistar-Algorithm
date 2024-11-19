import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄 입력받기
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]); // 정환이 아는 노래의 개수
        int M = Integer.parseInt(firstLine[1]); // 맞히기를 시도할 노래의 개수
        
        // 노래 정보 저장할 HashMap
        HashMap<String, List<String>> songMap = new HashMap<>();
        
        // N개의 노래 정보 입력받기
        for (int i = 0; i < N; i++) {
            String[] songInfo = br.readLine().split(" ");
            String title = songInfo[1]; // 노래 제목
            String firstThreeNotes = songInfo[2] + songInfo[3] + songInfo[4]; // 첫 세 음
            
            // HashMap에 첫 세 음으로 시작하는 노래 제목 리스트 저장
            songMap.putIfAbsent(firstThreeNotes, new ArrayList<>());
            songMap.get(firstThreeNotes).add(title);
        }
        
        // M개의 맞히기 시도 입력받기
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String[] tryNotes = br.readLine().split(" ");
            String guessNotes = tryNotes[0] + tryNotes[1] + tryNotes[2]; // 맞히기 시도 첫 세 음
            
            // 결과 판단
            if (songMap.containsKey(guessNotes)) {
                List<String> titles = songMap.get(guessNotes);
                if (titles.size() == 1) {
                    result.append(titles.get(0)).append("\n");
                } else {
                    result.append("?\n");
                }
            } else {
                result.append("!\n");
            }
        }
        
        // 결과 출력
        System.out.print(result);
    }
}
