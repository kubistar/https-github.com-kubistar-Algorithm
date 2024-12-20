import sys

# 입력 받기
n = int(input())
houses = list(map(int, input().split()))

# 중앙값 찾기
houses.sort()  # 정렬
median = houses[(n - 1) // 2]  # 중앙값 구하기 (짝수/홀수 처리 모두 포함)
print(median)
