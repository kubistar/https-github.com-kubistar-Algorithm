# 식 입력
expression = input()

# '-'로 구분하여 분리
parts = expression.split('-')

# 첫 번째 부분은 더해야 하는 값들의 합
total = sum(map(int, parts[0].split('+')))

# 그 이후 부분들은 모두 뺄셈 처리
for part in parts[1:]:
    total -= sum(map(int, part.split('+')))

# 결과 출력
print(total)
