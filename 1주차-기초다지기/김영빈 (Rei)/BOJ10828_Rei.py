# 10828 - 스택
import sys

N = int(sys.stdin.readline())
stk = []

for i in range(N):
    commands = sys.stdin.readline().split()
    if len(commands) == 2: # push일 경우
        num = int(commands[1])
        stk.append(num)
    else:
        cmd = commands[0]
        if cmd == "pop": # pop
            try:
                a = stk.pop()
                print(a)
            except:
                print(-1)
        elif cmd == "size": # size
            print(len(stk))
        elif cmd == "empty": # empty
            if len(stk) == 0:
                print(1)
            else:
                print(0)
        else: # top
            try:
                print(stk[-1])
            except:
                print(-1)