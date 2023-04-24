# 1158 - 요세푸스 문제

# 옛날 풀이 참고함 (옛날에도 구글링 했을 듯)
# 로직 생각하기 어려움...
import sys

N, K = map(int, sys.stdin.readline().split())
circle = [i for i in range(1,N+1)]
result = []
idx = 0  # 현재 위치 인덱스

for i in range(N):
    # 다음 인덱스 설정
    idx = idx + K-1
    # circle의 전체 길이를 넘어가면 인덱스를 circle 길이만큼 나눠줌
    if idx >= len(circle):
        idx = idx % len(circle)
    
    result.append(circle.pop(idx))
    
print("<", end="")
for i in range(N-1):
    print(result[i], end=", ")
print(f"{result[-1]}>")