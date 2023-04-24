# 2161 - 카드1

import sys
from collections import deque

N = int(sys.stdin.readline())
dq = deque()
result = []

# 1~N 카드 생성
for i in range(1,N+1):
    dq.append(i)

while True:
    # deque 길이가 1이 되면 반복문 빠져나오기
    if len(dq) == 1:
        break
    else:
        # 1) 제일 위 카드 버리기 (result 리스트에 추가)
        a = dq.popleft()
        result.append(a)

    # 2) 제일 위 카드 맨 밑으로
    b = dq.popleft()
    dq.append(b)

# 3) 마지막 남은 카드 result에 추가
result.append(dq[0])
    
for r in result:
    print(r, end=" ")