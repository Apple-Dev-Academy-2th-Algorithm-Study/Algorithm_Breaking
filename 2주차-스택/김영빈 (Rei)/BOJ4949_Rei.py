# 4949 - 균형잡힌 세상

# 처음에 생각한 방식 -> 문장에서 괄호들만 따로 빼옴 -> 바로 닫히는 괄호들 제거 -> 남은 괄호들 앞/뒤로 검사
# ==> 코드가 너무 지저분해짐... (if문 안에 if문 안에 if문...)
# 구글링해서 진짜 슥 보기만 함 ==> 스택 활용하면 될 것 같음

import sys

while True:
    userInput = sys.stdin.readline().rstrip() # 입력 받기

    # 마지막으로 열린 괄호 표시해주기
    opened = []
    result = True

    if userInput == ".": # 종료조건
        break
    
    # 문장 입력
    for chr in userInput:

        # 여는 괄호 확인
        if chr == "(":
            opened.append("mini")
        elif chr == "[":
            opened.append("maxi")
        
        # 닫는 괄호 확인
        if chr == ")":
            if opened == []: # 닫는게 먼저 나온 경우
                result = False
                break
            else:
                if opened[-1] == "mini": # 매칭이 되는 괄호가 마지막으로 열렸으면 pop
                    opened.pop()
                else:
                    result = False
                    break
        elif chr == "]":
            if opened == []:
                result = False
                break
            else:
                if opened[-1] == "maxi":
                    opened.pop()
                else:
                    result = False
                    break
    
    if opened != []:
        print("no")
    else:
        if result == False:
            print("no")
        else:
            print("yes")