import math
T = int(input())
for i in range(T):
    N, D = map(int, input().split())
    result = math.ceil(N / (2 * D + 1))
    print("#{} {}".format(i + 1, result))