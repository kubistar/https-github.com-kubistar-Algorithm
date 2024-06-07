def find_smallest_ticket(N, sold_tickets):
    sold_set = set(sold_tickets)
    ticket_number = 1
    
    while ticket_number in sold_set:
        ticket_number += 1
    
    return ticket_number

# 입력 받기
import sys
input = sys.stdin.read
data = input().split()

N = int(data[0])
sold_tickets = list(map(int, data[1:]))

# 결과 출력
print(find_smallest_ticket(N, sold_tickets))
