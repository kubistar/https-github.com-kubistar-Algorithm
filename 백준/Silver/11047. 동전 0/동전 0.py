def min_coin_count(N, K, coin_values):
    count = 0
    for value in reversed(coin_values):
        if K == 0:
            break
        count += K // value
        K %= value
    return count

# 입력 받기
N, K = map(int, input().split())
coin_values = [int(input()) for _ in range(N)]

# 최소 동전 개수 계산 및 출력
result = min_coin_count(N, K, coin_values)
print(result)
