import sys

n = int(sys.stdin.readline())

queue = []

for i in range(0, n):
    command = sys.stdin.readline().split()
    if (command[0] == "push"):
        queue.append(command[1])
    elif ((command[0] == "pop" or command[0] == "front" or command[0] == "back") and not queue):
        print(-1)
    elif (command[0] == "pop" and queue):
        print(queue[0])
        del queue[0] # Queue.pop(0) / queue.pop(-1)
    elif (command[0] == "size"):
        print(len(queue))
    elif (command[0] == "empty"):
        if not queue:
            print(1)
        else:
            print(0)
    elif (command[0] == "front"):
        print(queue[0])
    elif (command[0] == "back"):
        print(queue[len(queue) - 1])