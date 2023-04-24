# 18258 - 큐 2

import sys
from collections import deque

N = int(sys.stdin.readline())
queue = deque()

for i in range(N):
    command = sys.stdin.readline().rsplit()
    
    if len(command) == 2:
        cmd, num = command[0], command[1]
        queue.append(num)
    else:
        cmd = command[0]
        
        if cmd == "pop":
            try:
                print(queue.popleft())
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
        elif cmd == "back":
            try:
                print(queue[-1])
            except:
                print(-1)