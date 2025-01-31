import sys
import bisect

def main():
    input = sys.stdin.read
    data = input().split()

    # 입력 파싱
    idx = 0
    N = int(data[idx])
    idx += 1
    a = list(map(int, data[idx:idx + N]))
    idx += N
    Q = int(data[idx])
    idx += 1
    s = list(map(int, data[idx:idx + Q]))

    # 전처리: 누적 최대 값으로 배열 생성
    effective_a = [0] * N
    effective_a[0] = a[0]
    for i in range(1, N):
        effective_a[i] = max(effective_a[i - 1], a[i] + i)

    # 이진 탐색으로 각 도토리 처리
    result = []
    for size in s:
        index = bisect.bisect_left(effective_a, size)
        if index < N:
            result.append(str(index + 1))
        else:
            result.append(str(N))

    # 결과 출력
    sys.stdout.write(" ".join(result) + "\n")

if __name__ == "__main__":
    main()
