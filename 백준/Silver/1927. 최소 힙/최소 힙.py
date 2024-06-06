import heapq
import sys

input = sys.stdin.read

def main():
    input_data = input().split()
    N = int(input_data[0])
    commands = list(map(int, input_data[1:]))
    
    min_heap = []
    result = []
    
    for x in commands:
        if x > 0:
            heapq.heappush(min_heap, x)
        else:  # x == 0
            if min_heap:
                result.append(heapq.heappop(min_heap))
            else:
                result.append(0)
    
    # Output results
    for value in result:
        print(value)

if __name__ == "__main__":
    main()
