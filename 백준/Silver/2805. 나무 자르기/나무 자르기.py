def find_max_height(trees, N, M):
    # 이진 탐색의 범위
    start, end = 0, max(trees)
    answer = 0

    while start <= end:
        mid = (start + end) // 2
        
        # 잘라낸 나무 길이 계산
        cut_length = sum(tree - mid for tree in trees if tree > mid)
        
        # 잘라낸 나무의 길이가 필요한 M보다 크거나 같다면, 더 높은 높이를 시도
        if cut_length >= M:
            answer = mid  # 현재 높이를 저장
            start = mid + 1
        else:
            end = mid - 1

    return answer

# 입력
N, M = map(int, input().split())
trees = list(map(int, input().split()))

# 결과 출력
print(find_max_height(trees, N, M))
