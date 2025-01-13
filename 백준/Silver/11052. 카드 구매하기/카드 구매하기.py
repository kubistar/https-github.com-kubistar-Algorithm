# 카드 N개를 구매하기 위해 지불할 수 있는 최대 금액을 구하는 DP 풀이

def max_card_pack_value(n, prices):
    # dp[i]는 카드 i개를 구매하는 최대 금액을 저장하는 배열
    dp = [0] * (n + 1)

    # 1개부터 n개까지의 카드 수에 대해 최대 금액을 계산
    for i in range(1, n + 1):
        for j in range(1, i + 1):
            dp[i] = max(dp[i], dp[i - j] + prices[j - 1])

    return dp[n]

# 입력 처리
n = int(input())
prices = list(map(int, input().split()))

# 결과 출력
print(max_card_pack_value(n, prices))
