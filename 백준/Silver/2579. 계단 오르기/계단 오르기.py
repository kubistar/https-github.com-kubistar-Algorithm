n = int(input())  # 계단의 개수 입력
score = [0]  # 계단 점수를 저장할 리스트
for _ in range(n):
    score.append(int(input()))

# 계단이 하나일 경우 예외 처리
if n == 1:
    print(score[1])
else:
    dp = [0] * (n + 1)  # 최대 점수를 저장할 리스트
    dp[1] = score[1]
    dp[2] = score[1] + score[2]

    for i in range(3, n + 1):
        dp[i] = max(dp[i-2] + score[i], dp[i-3] + score[i-1] + score[i])

    print(dp[n])
