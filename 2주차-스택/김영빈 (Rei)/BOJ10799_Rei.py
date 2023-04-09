# 10799 - 쇠막대기
import sys

stick = ["("] # 안끝난 쇠막대기 체크용 스택
pipes = sys.stdin.readline().rstrip()
result = 1 # 결과 개수

for i in range(1,len(pipes)):
    # 열린 괄호
    if pipes[i] == "(":
        result += 1
        stick.append("(") # 스택에 추가해주기
    # 닫힌 괄호
    else:
        # 직전이 열린 괄호였다면 레이저임
        if pipes[i-1] == "(":
            result -= 1 # 개수 카운트 빼주고
            stick.pop() # 스택에서도 제거
            result += len(stick) # 끝나지 않은 쇠막대기들이 잘려서 2배 늘어남
        # 쇠막대기가 끝난 경우
        else:
            stick.pop()

print(result)