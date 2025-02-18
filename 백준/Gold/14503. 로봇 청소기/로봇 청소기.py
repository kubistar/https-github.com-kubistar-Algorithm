import sys
input = sys.stdin.read
sys.setrecursionlimit(10**6)

# 방향 벡터 (북, 동, 남, 서)
dx = [-1, 0, 1, 0]  # 북쪽(-1), 동쪽(0), 남쪽(+1), 서쪽(0)
dy = [0, 1, 0, -1]  # 북쪽(0), 동쪽(+1), 남쪽(0), 서쪽(-1)

def clean_room(N, M, r, c, d, room):
    visited = [[0] * M for _ in range(N)]
    count = 0  # 청소한 칸 개수

    while True:
        # 1. 현재 칸 청소
        if visited[r][c] == 0:
            visited[r][c] = 1
            count += 1  # 청소한 칸 증가

        # 2. 주변 4칸 확인
        found = False
        for _ in range(4):
            d = (d - 1) % 4  # 반시계 방향 회전
            nx, ny = r + dx[d], c + dy[d]

            if 0 <= nx < N and 0 <= ny < M and room[nx][ny] == 0 and visited[nx][ny] == 0:
                r, c = nx, ny
                found = True
                break

        # 3. 청소할 곳이 없으면 후진
        if not found:
            back_d = (d + 2) % 4  # 현재 방향의 반대 방향
            br, bc = r + dx[back_d], c + dy[back_d]

            if room[br][bc] == 1:  # 후진 불가능 (벽이면 종료)
                return count
            
            # 후진 가능하면 후진
            r, c = br, bc

# 입력 처리
data = input().split("\n")
N, M = map(int, data[0].split())
r, c, d = map(int, data[1].split())
room = [list(map(int, data[i+2].split())) for i in range(N)]

# 결과 출력
print(clean_room(N, M, r, c, d, room))
