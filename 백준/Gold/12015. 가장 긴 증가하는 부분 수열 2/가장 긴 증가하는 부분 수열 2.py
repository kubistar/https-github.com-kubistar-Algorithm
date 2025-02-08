import sys
from bisect import bisect_left

# 입력 처리
input = sys.stdin.read
data = input().split()

# 수열 크기 N과 수열 A
N = int(data[0])
A = list(map(int, data[1:]))

# LIS 배열 초기화
LIS = []

# LIS 구하기
for num in A:
    pos = bisect_left(LIS, num)
    if pos == len(LIS):
        LIS.append(num)
    else:
        LIS[pos] = num

# 출력
print(len(LIS))
