import sys

# 입력의 수가 많을 경우를 대비해 sys.stdin을 사용
input = sys.stdin.read
data = input().split()

# 첫 번째 줄은 N, 나머지는 정렬할 숫자들
N = int(data[0])
numbers = list(map(int, data[1:]))

# 숫자들을 오름차순으로 정렬
numbers.sort()

# 정렬된 숫자들을 출력
for number in numbers:
    print(number)
