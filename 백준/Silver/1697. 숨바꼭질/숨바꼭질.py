from collections import deque

def find_fastest_time(N, K):
    # 최대 위치 설정
    max_position = 100000
    # 방문 여부를 체크하기 위한 리스트
    visited = [False] * (max_position + 1)
    
    # BFS를 위한 큐 설정
    queue = deque([(N, 0)])  # (현재 위치, 현재 시간)
    visited[N] = True
    
    while queue:
        current_position, current_time = queue.popleft()
        
        # 동생을 찾았을 경우 현재 시간을 반환
        if current_position == K:
            return current_time
        
        # 다음 가능한 이동을 탐색
        next_positions = [current_position - 1, current_position + 1, current_position * 2]
        
        for next_position in next_positions:
            if 0 <= next_position <= max_position and not visited[next_position]:
                visited[next_position] = True
                queue.append((next_position, current_time + 1))

# 입력
N, K = map(int, input().split())

# 결과 출력
print(find_fastest_time(N, K))
