import heapq
import sys
input = sys.stdin.read

def minimum_cost_to_merge_files(file_sizes):
    heapq.heapify(file_sizes)
    total_cost = 0
    
    while len(file_sizes) > 1:
        first = heapq.heappop(file_sizes)
        second = heapq.heappop(file_sizes)
        cost = first + second
        total_cost += cost
        heapq.heappush(file_sizes, cost)
    
    return total_cost

def main():
    input_data = input().strip().split()
    T = int(input_data[0])
    index = 1
    results = []
    
    for _ in range(T):
        K = int(input_data[index])
        index += 1
        file_sizes = list(map(int, input_data[index:index + K]))
        index += K
        result = minimum_cost_to_merge_files(file_sizes)
        results.append(result)
    
    for result in results:
        print(result)

if __name__ == "__main__":
    main()
