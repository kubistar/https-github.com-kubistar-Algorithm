from collections import deque

def count_islands(w, h, grid):
    def bfs(x, y):
        queue = deque([(x, y)])
        visited[x][y] = True

        # 8방향을 정의합니다 (상하좌우 + 대각선)
        directions = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]
        
        while queue:
            cx, cy = queue.popleft()
            for dx, dy in directions:
                nx, ny = cx + dx, cy + dy
                if 0 <= nx < h and 0 <= ny < w and not visited[nx][ny] and grid[nx][ny] == 1:
                    visited[nx][ny] = True
                    queue.append((nx, ny))
    
    visited = [[False] * w for _ in range(h)]
    count = 0

    for i in range(h):
        for j in range(w):
            if grid[i][j] == 1 and not visited[i][j]:
                bfs(i, j)
                count += 1  # 섬 발견 시 count 증가
    return count

# 입력 처리
results = []
while True:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break
    grid = [list(map(int, input().split())) for _ in range(h)]
    results.append(count_islands(w, h, grid))

# 결과 출력
for result in results:
    print(result)
