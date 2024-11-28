# 메모이제이션을 위한 3차원 배열 초기화
memo = [[[None for _ in range(21)] for _ in range(21)] for _ in range(21)]

def w(a, b, c):
    if a <= 0 or b <= 0 or c <= 0:
        return 1
    if a > 20 or b > 20 or c > 20:
        return w(20, 20, 20)

    # 메모된 값이 있으면 바로 반환
    if memo[a][b][c] is not None:
        return memo[a][b][c]

    # 점화식 계산 및 메모이제이션 저장
    if a < b and b < c:
        memo[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
    else:
        memo[a][b][c] = (
            w(a-1, b, c)
            + w(a-1, b-1, c)
            + w(a-1, b, c-1)
            - w(a-1, b-1, c-1)
        )
    return memo[a][b][c]

# 입력 처리 및 출력
while True:
    a, b, c = map(int, input().split())
    if a == -1 and b == -1 and c == -1:
        break
    print(f"w({a}, {b}, {c}) = {w(a, b, c)}")
