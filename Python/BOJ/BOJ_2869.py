import math

a, b, v = input().split()

cnt = 1
cnt += (int(v) - int(a)) / (int(a) - int(b))
cnt = math.ceil(cnt)
print(f'{cnt:.0f}')
