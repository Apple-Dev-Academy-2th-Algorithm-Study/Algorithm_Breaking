# 10845 - 큐
import sys

N = int(sys.stdin.readline())
queue = []

for i in range(N):
    commands = sys.stdin.readline().split()
    if len(commands) == 2: # push
        num = commands[1]
        queue.append(num)
    else:
        cmd = commands[0]
        if cmd == "pop":
            try:
                a = queue.pop(0)
                print(a)
            except:
                print(-1)
        elif cmd == "size":
            print(len(queue))
        elif cmd == "empty":
            if len(queue) == 0:
                print(1)
            else:
                print(0)
        elif cmd == "front":
            try:
                print(queue[0])
            except:
                print(-1)
        else: # back
            try:
                print(queue[-1])
            except:
                print(-1)