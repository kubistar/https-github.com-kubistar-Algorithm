import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

class Document {
    int index;
    int priority;

    Document(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCases; t++) {
            String[] firstLine = br.readLine().split(" ");
            int n = Integer.parseInt(firstLine[0]); // 문서의 수
            int m = Integer.parseInt(firstLine[1]); // 궁금한 문서의 위치
            
            String[] secondLine = br.readLine().split(" ");
            Queue<Document> queue = new LinkedList<>();
            
            // 큐에 문서 추가
            for (int i = 0; i < n; i++) {
                queue.add(new Document(i, Integer.parseInt(secondLine[i])));
            }
            
            int printOrder = 0;
            
            while (!queue.isEmpty()) {
                Document current = queue.poll();
                boolean hasHigherPriority = false;
                
                // 남아있는 문서들 중 현재 문서보다 중요도가 높은 문서가 있는지 확인
                for (Document doc : queue) {
                    if (doc.priority > current.priority) {
                        hasHigherPriority = true;
                        break;
                    }
                }
                
                if (hasHigherPriority) {
                    // 중요도가 더 높은 문서가 있다면, 현재 문서를 큐의 뒤로 보냄
                    queue.add(current);
                } else {
                    // 그렇지 않다면 문서를 인쇄
                    printOrder++;
                    if (current.index == m) {
                        // 우리가 찾던 문서라면 결과 출력
                        System.out.println(printOrder);
                        break;
                    }
                }
            }
        }
    }
}
