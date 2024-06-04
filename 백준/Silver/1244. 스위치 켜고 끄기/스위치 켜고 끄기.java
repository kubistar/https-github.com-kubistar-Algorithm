import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); // 스위치 개수
        int[] switches = new int[n];

        // 스위치 초기 상태 입력
        String[] switchStates = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            switches[i] = Integer.parseInt(switchStates[i]);
        }

        int studentCount = Integer.parseInt(br.readLine()); // 학생 수
        int[][] students = new int[studentCount][2];

        // 학생 정보 입력
        for (int i = 0; i < studentCount; i++) {
            String[] studentInfo = br.readLine().split(" ");
            students[i][0] = Integer.parseInt(studentInfo[0]); // 성별
            students[i][1] = Integer.parseInt(studentInfo[1]); // 받은 수
        }

        // 학생들의 행동에 따른 스위치 상태 변경
        for (int[] student : students) {
            int gender = student[0];
            int number = student[1];

            if (gender == 1) { // 남학생
                for (int i = number - 1; i < n; i += number) {
                    switches[i] = 1 - switches[i];
                }
            } else if (gender == 2) { // 여학생
                int idx = number - 1;
                switches[idx] = 1 - switches[idx];
                int left = idx - 1;
                int right = idx + 1;

                while (left >= 0 && right < n && switches[left] == switches[right]) {
                    switches[left] = 1 - switches[left];
                    switches[right] = 1 - switches[right];
                    left--;
                    right++;
                }
            }
        }

        // 최종 스위치 상태 출력 (20개씩 끊어서)
        for (int i = 0; i < n; i++) {
            System.out.print(switches[i] + " ");
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
        if (n % 20 != 0) {
            System.out.println();
        }
    }
}
