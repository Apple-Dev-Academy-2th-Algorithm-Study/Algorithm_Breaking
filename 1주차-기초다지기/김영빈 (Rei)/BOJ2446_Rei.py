# 2446 - 별 찍기 - 9
import sys

N = int(sys.stdin.readline())
for i in range(N-1, 0, -1):
    print(" " * (N-i-1), end="")
    print("*" * (i*2+1))
print(" " * (N-1), end="")
print("*")
for i in range(1, N):
    print(" " * (N-i-1), end="")
    print("*" * (i*2+1))