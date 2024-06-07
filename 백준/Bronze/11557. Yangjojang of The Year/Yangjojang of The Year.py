# 테스트 케이스 수 입력
T = int(input().strip())

# 각 테스트 케이스 처리
for _ in range(T):
    # 학교 수 입력
    N = int(input().strip())
    
    # 최대 술 소비량과 해당 학교 이름 초기화
    max_alcohol = -1
    school_with_max_alcohol = ""
    
    # 각 학교 정보 입력 및 처리
    for _ in range(N):
        data = input().strip().split()
        school_name = data[0]
        alcohol_consumption = int(data[1])
        
        # 현재 학교의 술 소비량이 최대값보다 큰지 확인
        if alcohol_consumption > max_alcohol:
            max_alcohol = alcohol_consumption
            school_with_max_alcohol = school_name
    
    # 현재 테스트 케이스에서 술 소비가 가장 많은 학교 이름 출력
    print(school_with_max_alcohol)
