def get_compatibility(a, b):
    # 초기 숫자열 생성
    combined = [0] * 16
    for i in range(8):
        combined[2*i] = int(a[i])
        combined[2*i + 1] = int(b[i])
    
    # 궁합 계산
    while len(combined) > 2:
        temp = []
        for i in range(len(combined) - 1):
            temp.append((combined[i] + combined[i + 1]) % 10)
        combined = temp
    
    # 최종 결과 출력
    return f"{combined[0]}{combined[1]}"

# 입력
a = input().strip()
b = input().strip()

# 결과 출력
print(get_compatibility(a, b))
