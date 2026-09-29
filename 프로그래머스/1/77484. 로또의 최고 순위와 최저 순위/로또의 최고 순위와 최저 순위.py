def solution(lottos, win_nums):
    rank = [6, 6, 5, 4, 3, 2, 1]
    matched = len(set(lottos) & set(win_nums))
    zeros = lottos.count(0)
    return [rank[matched + zeros], rank[matched]]