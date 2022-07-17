t = int(input())
for i in range(t):
    h, w, n = map(int, input().split())
    yy = n % h
    xx = n // h + 1
    if yy == 0:
        yy = h
        xx -= 1
    print(f'{yy}%02d' % xx)
