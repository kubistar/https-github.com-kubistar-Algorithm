class Solution {
    // 입력: n은 컴퓨터 개수, computers는 n×n 배열로 누가 누구랑 연결됐는지(1이면 연결)
    //출력: 네트워크 개수
    boolean[] visited;   // visited[i] = i번 컴퓨터 방문했는지
    int[][] computers;   // dfs에서도 써야 해서 필드로 뺌
    int n;               // 컴퓨터 개수 (dfs for문 범위용)

    public int solution(int n, int[][] computers) {
        // 파라미터를 필드에 저장 → dfs에서 접근 가능
        this.n = n;
        this.computers = computers;
        visited = new boolean[n];   // 처음엔 전부 false (아무도 방문 안 함)
        int answer = 0;             // 네트워크 개수

        // 0번부터 n-1번 컴퓨터까지 하나씩 확인
        for (int i = 0; i < n; i++) {
            // 아직 방문 안 했다 = 새로운 네트워크의 시작점
            if (!visited[i]) {
                dfs(i);      // i랑 연결된 컴퓨터 전부 방문 처리 (덩어리 하나 소비)
                answer++;    // 네트워크 하나 카운트
            }
            // 이미 방문했으면 앞에서 센 네트워크 소속이니까 스킵
        }
        return answer;
    }

    // cur번 컴퓨터에서 출발해서 연결된 모든 컴퓨터 방문
    void dfs(int cur) {
        // 들어오자마자 방문 표시 (늦게 찍으면 서로 계속 호출해서 무한재귀)
        visited[cur] = true;

        // cur번 행 = cur의 연결 목록. 0 ~ n-1번 다 확인
        for (int next = 0; next < n; next++) {
            // 연결돼 있고(1) + 아직 안 갔으면 → 거기로 이동
            if (computers[cur][next] == 1 && !visited[next]) {
                dfs(next);   // next에서 또 연결된 애들 따라감 (간접 연결도 이렇게 잡힘)
            }
        }
        // for 끝 = cur에서 갈 수 있는 곳 다 감 → 이전 호출로 돌아감
    }
}