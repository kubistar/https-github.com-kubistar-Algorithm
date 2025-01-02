def max_candies(N, M, candy):
    # DP 테이블 초기화
    dp = [[0] * M for _ in range(N)]
    
    # DP 배열 채우기
    for r in range(N):
        for c in range(M):
            # 현재 위치의 사탕 개수
            current_candy = candy[r][c]
            
            # 위쪽, 왼쪽, 대각선에서 오는 값들 확인
            from_top = dp[r-1][c] if r > 0 else 0
            from_left = dp[r][c-1] if c > 0 else 0
            from_diag = dp[r-1][c-1] if r > 0 and c > 0 else 0
            
            # 점화식 적용
            dp[r][c] = current_candy + max(from_top, from_left, from_diag)
    
    # 최종 결과
    return dp[N-1][M-1]

# 입력 처리
N, M = map(int, input().split())
candy = [list(map(int, input().split())) for _ in range(N)]

# 결과 출력
print(max_candies(N, M, candy))
