# 10952 - A+B-5
import sys

while True:
    A, B = sys.stdin.readline().split()
    if A=="0" and B=="0":
        break
    else:
        print(int(A)+int(B))