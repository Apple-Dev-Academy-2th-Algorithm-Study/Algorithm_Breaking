# 1966 - 프린터 큐
import sys
from collections import deque

T = int(sys.stdin.readline()) # 테스트 케이스 개수
for i in range(T):
    M, N = map(int, sys.stdin.readline().split()) # M:문서 개수, N:궁금한 문서 인덱스
    priorities = deque(map(int, sys.stdin.readline().split())) # 중요도

    cnt = 0 # 출력된 횟수
    now = N # 궁금한 문서의 현재 인덱스
    while True:
        maximum = max(priorities) # 가장 높은 우선순위

        if priorities[0] >= maximum: # 가장 앞의 문서보다 높은 우선순위가 없으면 출력
            cnt += 1
            if now == 0: # 현재 출력할 인덱스가 궁금한 문서라면 결과 출력 후 break
                print(cnt)
                break
            else:
                priorities.popleft()
                now -= 1
        else: # 그렇지 않으면 맨 뒤로 보냄
            priorities.append(priorities.popleft())
            # 맨 뒤로 보낸 문서가 궁금한 문서인지 체크하고, 그에 맞게 now값 갱신
            if now == 0:
                now = len(priorities)-1
            else:
                now -= 1