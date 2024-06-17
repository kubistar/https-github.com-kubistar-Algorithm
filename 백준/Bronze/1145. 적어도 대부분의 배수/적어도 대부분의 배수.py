import math
from itertools import combinations

def lcm(x, y):
    return abs(x * y) // math.gcd(x, y)

def lcm_of_three(a, b, c):
    return lcm(lcm(a, b), c)

def at_least_most_multiple(numbers):
    comb = combinations(numbers, 3)
    min_lcm = float('inf')
    
    for a, b, c in comb:
        current_lcm = lcm_of_three(a, b, c)
        if current_lcm < min_lcm:
            min_lcm = current_lcm
    
    return min_lcm

# 입력
numbers = list(map(int, input().split()))

# 출력
print(at_least_most_multiple(numbers))
