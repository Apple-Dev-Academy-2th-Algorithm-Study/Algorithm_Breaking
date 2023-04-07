import sys
from collections import deque

n = int(sys.stdin.readline())
deq = deque()

for i in range (0, n):
    command = sys.stdin.readline().split()
    if command[0] == "push_front":
        deq.appendleft(command[1])
    elif command[0] == "push_back":
        deq.append(command[1])
    elif command[0] == "pop_front" and deq:
        print(deq.popleft())
    elif command[0] == "pop_back" and deq:
        print(deq.pop())
    elif command[0] == "size":
        print(len(deq))
    elif command[0] == "empty":
        if deq:
            print(0)
        else:
            print(1)
    elif command[0] == "front" and deq:
        print(deq[0])
    elif command[0] == "back" and deq:
        print(deq[len(deq) - 1])
    else:
        print(-1)
    
