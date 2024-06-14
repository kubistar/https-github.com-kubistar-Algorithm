import heapq
import sys
input = sys.stdin.read
INF = int(1e9)

def dijkstra(start, graph, n):
    distances = [INF] * (n + 1)
    distances[start] = 0
    priority_queue = []
    heapq.heappush(priority_queue, (0, start))
    
    while priority_queue:
        current_distance, current_node = heapq.heappop(priority_queue)
        
        if current_distance > distances[current_node]:
            continue
        
        for neighbor, weight in graph[current_node]:
            distance = current_distance + weight
            
            if distance < distances[neighbor]:
                distances[neighbor] = distance
                heapq.heappush(priority_queue, (distance, neighbor))
    
    return distances

def find_shortest_path(n, edges, v1, v2):
    graph = [[] for _ in range(n + 1)]
    
    for u, v, w in edges:
        graph[u].append((v, w))
        graph[v].append((u, w))
    
    distance_from_1 = dijkstra(1, graph, n)
    distance_from_v1 = dijkstra(v1, graph, n)
    distance_from_v2 = dijkstra(v2, graph, n)
    
    path1 = distance_from_1[v1] + distance_from_v1[v2] + distance_from_v2[n]
    path2 = distance_from_1[v2] + distance_from_v2[v1] + distance_from_v1[n]
    
    result = min(path1, path2)
    
    if result >= INF:
        return -1
    else:
        return result

def main():
    input_data = input().split()
    index = 0
    n = int(input_data[index])
    index += 1
    e = int(input_data[index])
    index += 1
    
    edges = []
    for _ in range(e):
        a = int(input_data[index])
        index += 1
        b = int(input_data[index])
        index += 1
        c = int(input_data[index])
        index += 1
        edges.append((a, b, c))
    
    v1 = int(input_data[index])
    index += 1
    v2 = int(input_data[index])
    
    print(find_shortest_path(n, edges, v1, v2))

if __name__ == "__main__":
    main()
