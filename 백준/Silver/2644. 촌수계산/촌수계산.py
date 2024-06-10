from collections import deque

def find_kinship(n, start, end, relationships):
    graph = {i: [] for i in range(1, n+1)}
    
    for x, y in relationships:
        graph[x].append(y)
        graph[y].append(x)
    
    def bfs(start, end):
        queue = deque([(start, 0)])
        visited = set()
        visited.add(start)
        
        while queue:
            current, distance = queue.popleft()
            
            if current == end:
                return distance
            
            for neighbor in graph[current]:
                if neighbor not in visited:
                    visited.add(neighbor)
                    queue.append((neighbor, distance + 1))
        
        return -1
    
    return bfs(start, end)

# 입력 처리
n = int(input().strip())
start, end = map(int, input().strip().split())
m = int(input().strip())
relationships = [tuple(map(int, input().strip().split())) for _ in range(m)]

# 촌수 계산
result = find_kinship(n, start, end, relationships)
print(result)