def dfs(graph, start, visited):
    # 현재 정점을 방문 처리
    for next_node in range(len(graph)):
        # 만약 현재 노드에서 다음 노드로 갈 수 있고, 방문한 적이 없다면
        if graph[start][next_node] == 1 and not visited[next_node]:
            visited[next_node] = True  # 방문 처리
            dfs(graph, next_node, visited)  # 다음 노드로 재귀적으로 탐색

# 입력 받기
N = int(input())  # 정점의 개수
graph = [list(map(int, input().split())) for _ in range(N)]

# 결과 저장을 위한 2차원 배열
result = [[0] * N for _ in range(N)]

# 각 정점에서 DFS 탐색
for i in range(N):
    visited = [False] * N  # 방문 여부를 체크하기 위한 리스트
    dfs(graph, i, visited)
    # DFS로 탐색한 결과를 인접 행렬로 저장
    for j in range(N):
        if visited[j]:
            result[i][j] = 1

# 결과 출력
for row in result:
    print(' '.join(map(str, row)))
