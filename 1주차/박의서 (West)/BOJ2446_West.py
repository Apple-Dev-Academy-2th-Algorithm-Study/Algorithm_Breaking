n = int(input())

for i in range (0,n-1):
    string = ""
    space = 0
    stars = 0
    while space < i:
        string += " "
        space += 1
    while stars < 2*(n - space) - 1:
        string += "*"
        stars += 1 # print(, end ) 이용
    print(string)

for i in range (n-1,-1, -1):
    string = ""
    space = 0
    stars = 0
    while space < i:
        string += " "
        space += 1
    while stars < 2*(n - space) - 1:
        string += "*"
        stars += 1
    print(string)
    