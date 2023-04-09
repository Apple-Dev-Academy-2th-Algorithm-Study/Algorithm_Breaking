# 9093 - 단어 뒤집기
import sys

T = int(sys.stdin.readline())
for i in range(T):
    words = sys.stdin.readline().split()
    for word in words:
        print(word[::-1], end=" ") # @@@@거꾸로 출력@@@@
    print()