# 17298 - 오큰수

# [처음 풀이]
# 커서 문제처럼 왼쪽부터 좌우로 나눈 리스트를 보고 비교
# ==> 2중 for문이라 시간 초과 (로직은 맞는 것 같음)
# import sys
# from collections import deque

# N = int(sys.stdin.readline())
# right = deque(list(sys.stdin.readline().split()))
# left = [] # 왼쪽 수
# result = []

# for i in range(0,N):
#     if i == N-1:
#         result.append(-1)
#     else:
#         left.append(right.popleft())
#         okensu = False
#         j = 0
#         for j in range(len(right)):
#             if left[-1] < right[j]:
#                 okensu = True
#                 result.append(right[j])
#                 break
#         if okensu == False:
#             result.append(-1)

# print(result)


# [구글링 풀이]
# 1. stk에는 0부터 시작해서 수열 arr의 인덱스를 차례로 넣어준다.
# 2. 인덱스 i=1부터 시작해서 비교한다.
# 3. {수열에서 현재 인덱스 값(arr[i])} 이 {수열에서 stk의 끝에 들어있는 인덱스에 해당하는 값} 보다 크다면 오큰수이므로 stk[-1]에 해당하는 인덱스의 result값을 오큰수로 교체해준다.
# 4. 오큰수 판정이 끝난 인덱스는 stk에서 제거해준다.
# 5. 그 외의 경우에는 stk에 인덱스를 계속 추가해준다.
import sys

N = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
result = [-1 for _ in range(N)]
stk = [0]

for i in range(1, N):
    while stk and arr[stk[-1]] < arr[i]: # stk이 조건에 왜 들어가는건지 알려주실분
        result[stk[-1]] = arr[i]
        stk.pop()
    
    stk.append(i)

for r in result:
    print(r, end=' ')