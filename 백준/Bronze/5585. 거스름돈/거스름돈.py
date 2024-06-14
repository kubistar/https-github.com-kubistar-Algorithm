def count_coins(paid_amount):
    change = 1000 - paid_amount
    coins = [500, 100, 50, 10, 5, 1]
    coin_count = 0
    
    for coin in coins:
        coin_count += change // coin
        change %= coin
    
    return coin_count

# 입력
paid_amount = int(input())

# 잔돈의 개수 출력
print(count_coins(paid_amount))
