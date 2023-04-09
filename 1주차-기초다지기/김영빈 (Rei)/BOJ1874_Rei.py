# 1874 - 스택 수열
import sys
from collections import deque

n = int(sys.stdin.readline())
arr = deque()

# 수열 입력받기
for i in range(n):
    arr.append(int(sys.stdin.readline()))

result = ["+"]
stk = [1]
error = 0
i = 2

while True:
    if error == 1: # 수열을 만들 수 없다면 빠져나옴
        break
    if len(stk) == 0 and len(arr) == 0: # 수열을 다 만들었다면 빠져나옴
        break

    while stk == [] or arr[0] > stk[-1]:
        stk.append(i)
        result.append("+")
        i += 1
    
    if stk[-1] == arr[0]: # 수열과 스택의 마지막 수가 매칭이 되면 pop을 시켜준다.
        stk.pop()
        arr.popleft()
        result.append("-")
    else: # 스택의 마지막 수가 현재 수열에서 찾아야 하는 수보다 크면 수열을 만들 수 X
        error = 1

if error == 1:
    print("NO")
else:
    for r in result:
        print(r)