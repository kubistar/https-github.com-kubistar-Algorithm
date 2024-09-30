def max_length_with_two_fruits(N, fruits):
    from collections import defaultdict
    
    # 과일 종류의 빈도수를 저장하는 딕셔너리
    fruit_count = defaultdict(int)
    
    l = 0
    max_length = 0
    
    # 오른쪽 포인터를 이동하면서 탐색
    for r in range(N):
        fruit_count[fruits[r]] += 1
        
        # 과일 종류가 2종류를 초과할 경우
        while len(fruit_count) > 2:
            fruit_count[fruits[l]] -= 1
            if fruit_count[fruits[l]] == 0:
                del fruit_count[fruits[l]]
            l += 1
        
        # 현재 부분 배열의 길이를 계산하고 최댓값을 갱신
        max_length = max(max_length, r - l + 1)
    
    return max_length

# 입력 예시
N = int(input())
fruits = list(map(int, input().split()))

# 결과 출력
print(max_length_with_two_fruits(N, fruits))
