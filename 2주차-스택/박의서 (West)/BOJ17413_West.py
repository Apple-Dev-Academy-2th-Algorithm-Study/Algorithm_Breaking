import sys

inputs = sys.stdin.readline().strip()
results = ""
i = 0
start = 0

while i < len(inputs):
    if inputs[i] == "<":
        start = i
        i += 1
        while inputs[i] != ">":
            i += 1
        results += inputs[start:i+1]
    elif inputs[i].isalnum():
        start = i
        i += 1
        while i < len(inputs) and inputs[i] != " " and inputs[i] != "<":
            i += 1
        temp = inputs[start:i]
        results += temp[::-1]
    elif inputs[i] == " ":
        i += 1
        results += " "
    else:
        i += 1
print(results)