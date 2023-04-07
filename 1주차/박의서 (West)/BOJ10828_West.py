import sys
n = int(sys.stdin.readline())

stack = []

def push():
    stack.append(int(command[1]))
def pop():
    if not stack:
        print("-1")
    else:
        print(stack.pop())
def size():
    print(len(stack))
def empty():
    if (stack):
        print(0)
    else: print(1)
def top():
    if not stack:
        print("-1") # Try- except 이용
    else:
        print(stack[len(stack) - 1])

def switch(command):
    return {
        "push": push,
        "pop": pop, 
        "size": size, 
        "empty": empty, 
        "top": top
        }.get(command[0])
# switch(case)

for i in range (0,n):
    command = sys.stdin.readline().split()
    switch(command)() 
