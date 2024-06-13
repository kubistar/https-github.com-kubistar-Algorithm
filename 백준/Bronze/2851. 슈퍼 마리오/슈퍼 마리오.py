# 버섯 점수를 입력받아 리스트로 저장
mushroom_scores = []
for _ in range(10):
    mushroom_scores.append(int(input().strip()))

# 초기화
current_sum = 0
closest_sum = 0

# 점수를 누적하며 계산
for score in mushroom_scores:
    current_sum += score
    if current_sum >= 100:
        # 100을 초과했을 때 이전의 누적합과 현재 누적합 중 100에 가까운 값을 선택
        if abs(100 - current_sum) < abs(100 - closest_sum):
            closest_sum = current_sum
        elif abs(100 - current_sum) == abs(100 - closest_sum):
            closest_sum = max(current_sum, closest_sum)
        break
    closest_sum = current_sum

print(closest_sum)
