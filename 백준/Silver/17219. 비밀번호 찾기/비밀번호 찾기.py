# 입력 받기
N, M = map(int, input().split())
password_dict = {}

# N개의 사이트 주소와 비밀번호 입력 받기
for _ in range(N):
    site, password = input().split()
    password_dict[site] = password

# M개의 사이트 주소에 대해 비밀번호 출력
for _ in range(M):
    site = input().strip()
    print(password_dict[site])
