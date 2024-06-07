# 아홉 명의 난쟁이 키를 입력받습니다.
dwarfs = [int(input().strip()) for _ in range(9)]

# 아홉 명의 난쟁이 키의 합을 구합니다.
total_sum = sum(dwarfs)

# 키의 합에서 100을 뺀 값을 구합니다.
target = total_sum - 100

# 두 명의 난쟁이 키를 선택하여 그 합이 target과 같은지 확인합니다.
found = False
for i in range(8):
    for j in range(i + 1, 9):
        if dwarfs[i] + dwarfs[j] == target:
            dwarf1, dwarf2 = dwarfs[i], dwarfs[j]
            found = True
            break
    if found:
        break

# 선택된 두 난쟁이를 제외한 나머지 일곱 난쟁이 키를 구합니다.
remaining_dwarfs = [d for d in dwarfs if d != dwarf1 and d != dwarf2]

# 일곱 난쟁이 키를 오름차순으로 정렬하여 출력합니다.
remaining_dwarfs.sort()
for dwarf in remaining_dwarfs:
    print(dwarf)
