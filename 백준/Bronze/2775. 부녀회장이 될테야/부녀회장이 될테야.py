def calculate_people():
    # 아파트 최대 층과 최대 호수 설정
    max_k = 14
    max_n = 14
    
    # DP 테이블 초기화
    dp = [[0] * (max_n + 1) for _ in range(max_k + 1)]
    
    # 0층의 각 호수에 사람 수 초기화
    for i in range(1, max_n + 1):
        dp[0][i] = i
    
    # DP를 이용하여 각 층의 사람 수 계산
    for k in range(1, max_k + 1):
        for n in range(1, max_n + 1):
            dp[k][n] = dp[k][n-1] + dp[k-1][n]
    
    return dp

# DP 테이블 미리 계산
dp = calculate_people()

# 테스트 케이스 입력 받기
t = int(input().strip())

results = []
for _ in range(t):
    k = int(input().strip())
    n = int(input().strip())
    results.append(dp[k][n])

# 결과 출력
for result in results:
    print(result)
