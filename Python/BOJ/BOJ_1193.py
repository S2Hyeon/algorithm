num = int(input())
cnt = 0
max_num = 0

while max_num < num:
    cnt += 1
    max_num += cnt

gap = max_num - num

if cnt % 2 == 0:
    numerator = cnt - gap
    denominator = gap + 1
else:
    numerator = gap + 1
    denominator = cnt - gap
print(str(numerator) + '/' + str(denominator))
