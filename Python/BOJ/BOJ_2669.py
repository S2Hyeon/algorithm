arr = [[0] * 101 for i in range(101)]
for tc in range(4):
    x1, y1, x2, y2 = map(int, input().split())
    for i in range(x2 - x1):
        for j in range(y2 - y1):
            arr[x1 + i][y1 + j] = 1

result = 0

for i in range(101):
    for j in range(101):
        result += arr[i][j]

print(result)
