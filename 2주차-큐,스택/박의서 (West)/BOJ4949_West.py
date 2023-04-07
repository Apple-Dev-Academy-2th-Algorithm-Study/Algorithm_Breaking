import sys

# stack 이용, 소괄호 - 1, 대괄호 - 2 문장 끝나고 스택 모두 빠지면 yes. 빠진 게 기대와 맞지 않으면 no
# 문장의 마침표는 .

while 1:
    stack = []
    inputs = sys.stdin.readline()
    if inputs == ".\n":
        break
    for char in inputs:
        if char == "(":
            stack.append(1)
        elif char == ")":
            try:
                if stack.pop() != 1:
                    print("no")
                    break
            except:
                print("no")
                break
        elif char == "[":
            stack.append(2)
        elif char == "]":
            try:
                if stack.pop() != 2:
                    print("no")
                    break
            except:
                print("no")
                break
        elif char == ".":
            if len(stack) > 0:
                print("no")
            else:
                print("yes")
            break