import sys
input = sys.stdin.readline

m = int(input())
n = int(input())
minValue = 10000
sumOfPrime = 0

for i in range(m, n + 1):
    cnt = 1
    if i < 2:
        continue
    for j in range(2, int(i ** 0.5) + 1):
        if i % j == 0:
            cnt += 1
    if cnt == 1:
        sumOfPrime += i
        if i < minValue:
            minValue = i
if sumOfPrime == 0:
    print(-1)
else:
    print(sumOfPrime)
    print(minValue)
