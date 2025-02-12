import sys
from collections import defaultdict

# 입력 받기
N = int(sys.stdin.readline().strip())

# 확장자 개수를 저장할 딕셔너리
ext_count = defaultdict(int)

# 확장자 추출 및 카운트
for _ in range(N):
    filename = sys.stdin.readline().strip()
    ext = filename.split(".")[1]  # 점을 기준으로 나누고 확장자 추출
    ext_count[ext] += 1

# 사전순 정렬 후 출력
for ext in sorted(ext_count.keys()):
    print(ext, ext_count[ext])
