def max_milk(N, shops):
    # 현재 마셔야 할 우유 종류를 추적하는 변수 (0: 딸기, 1: 초코, 2: 바나나)
    current_milk = 0
    count = 0

    for shop in shops:
        if shop == current_milk:
            count += 1
            current_milk = (current_milk + 1) % 3  # 다음 우유로 변경

    return count

# 입력
N = int(input())
shops = list(map(int, input().split()))

# 최대 마실 수 있는 우유 개수 출력
print(max_milk(N, shops))
