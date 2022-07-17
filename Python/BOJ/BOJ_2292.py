num = int(input())
cur = 1
cnt = 1
while True:
    if num <= cur:
        break
    cur += 6 * cnt
    cnt += 1

print(cnt)
