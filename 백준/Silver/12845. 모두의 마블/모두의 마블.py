n = int(input())

level = list(map(int, input().split()))

level.sort(reverse=True)

gold = 0

for i in range(len(level)-1):

    i = 0

    gold += level[i] + level[i+1]

    del level[i+1]

print(gold)