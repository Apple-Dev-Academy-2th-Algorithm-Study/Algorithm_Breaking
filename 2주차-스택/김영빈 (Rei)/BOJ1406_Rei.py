# 1406 - 에디터
# 처음에는 커서에 +1 -1만 해주면서 커서를 기준으로 문자열 슬라이싱해줌 ==> 시간초과
# 리스트 슬라이싱은 슬라이싱되는 요소들 수 만큼 비례하는 시간복잡도를 갖고 있음 --> 그래서 시간 초과 난 것 같은디 (문자열 길이 100,000)

# [구글링 및 옛날 풀이 참고]
# 커서를 기준으로 리스트를 좌우 2개로 나눠서 시간복잡도가 O(1)인 append와 pop만 수행해준다.
# ex) [1, 2, 3] [6, 5, 4]
# 마지막에는 오른쪽을 뒤집은 뒤 양쪽을 합쳐주기만 하면 끗
import sys

str_left = list(sys.stdin.readline().rstrip())
str_right = []
M = int(sys.stdin.readline())

for i in range(M):
    cmd = sys.stdin.readline().rstrip()
    if cmd == "L": # 커서 왼쪽으로
        if str_left != []:
            str_right.append(str_left.pop())
    elif cmd == "D": # 커서 오른쪽으로
        if str_right != []:
            str_left.append((str_right.pop()))
    elif cmd == "B": # 커서 왼쪽 문자 삭제
        if str_left != []:
            str_left.pop()
    else: # P $ : $라는 문자를 커서 왼쪽에 추가
        add = cmd.split()[1]
        str_left.append(add)

str_right.reverse()
print(''.join(str_left + str_right)) # join함수로 출력하면 훨씬 빠름