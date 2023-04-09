# 10866 - 덱
import sys
from collections import deque

N = int(sys.stdin.readline())
dq = deque()

for i in range(N):
    commands = sys.stdin.readline().split()
    if len(commands) == 2:
        cmd, num = commands[0], commands[1]
        if cmd == "push_front":
            dq.appendleft(num)
        else: # push_back
            dq.append(num)
    else:
        cmd = commands[0]
        if cmd == "pop_front":
            try:
                a = dq.popleft()
                print(a)
            except:
                print(-1)
        elif cmd == "pop_back":
            try:
                a = dq.pop()
                print(a)
            except:
                print(-1)
        elif cmd == "size":
            print(len(dq))
        elif cmd == "empty":
            if len(dq) == 0:
                print(1)
            else:
                print(0)
        elif cmd == "front":
            try:
                print(dq[0])
            except:
                print(-1)
        else: # back
            try:
                print(dq[-1])
            except:
                print(-1)