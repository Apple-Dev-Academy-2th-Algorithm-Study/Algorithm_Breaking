# 17413 - 단어 뒤집기 2

# >와< 사이에 있는 단어들만 공백 구분과 거꾸로 출력을 해줘야함
# <로 시작할 때 태그임을 체크하고, >로 끝나면 태그가 끝났음을 체크함 (<와 >는 반드시 번갈아 가면서 나옴)
import sys

S = sys.stdin.readline().rstrip()
result = "" # 출력할 문자열
isTag = 0

# 단어 뒤집어서 반환해주는 함수
def reverse_word(word):
    word = word[::-1]
    return word

temp = ""
for c in S:
    # 태그가 시작될 때
    if c == "<":
        # 뒤집을 단어가 있으면 뒤집어서 result에 넣어준다.
        if temp != "":
            temp = reverse_word(temp)
            result += temp
            temp = ""
        isTag = 1 # 태그임을 표시
        result += c
    # 태그가 끝났을 때
    elif c == ">":
        isTag = 0 # 태그 끝남 표시
        result += c
    else:
        if isTag == 1: # 태그를 이루는 단어일 때
            result += c
        else: # <도, >도 아니고 태그도 아닐 때
            if c == " ": # 공백일 경우
                temp = reverse_word(temp)
                result += temp
                result += " "
                temp = ""
            else: # 거꾸로 출력해야 하는 단어일 때
                temp += c

# 태그로 끝나지 않는 경우 결과로 들어가지 못한 마지막 단어 처리
if S[-1] != ">":
    temp = reverse_word(temp)
    result += temp

print(result)