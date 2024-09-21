def count_paper(x, y, size):
    global white_count, blue_count
    
    # 현재 영역의 첫 번째 색상을 기준으로 비교
    initial_color = paper[x][y]
    
    # 영역을 모두 탐색하여 색상이 같은지 확인
    is_same_color = True
    for i in range(x, x + size):
        for j in range(y, y + size):
            if paper[i][j] != initial_color:
                is_same_color = False
                break
        if not is_same_color:
            break
    
    # 모두 같은 색이라면 해당 색의 카운트 증가
    if is_same_color:
        if initial_color == 0:
            white_count += 1
        else:
            blue_count += 1
    else:
        # 색상이 다르면 4등분하여 재귀적으로 다시 탐색
        half_size = size // 2
        count_paper(x, y, half_size)
        count_paper(x, y + half_size, half_size)
        count_paper(x + half_size, y, half_size)
        count_paper(x + half_size, y + half_size, half_size)

# 입력 데이터 처리
N = int(input())
paper = [list(map(int, input().split())) for _ in range(N)]

# 색종이 수를 세기 위한 변수 초기화
white_count = 0
blue_count = 0

# 분할 정복 함수 호출
count_paper(0, 0, N)

# 결과 출력
print(white_count)
print(blue_count)
