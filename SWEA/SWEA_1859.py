T = int(input())
for tc in range(T):
    N = int(input())
    num = list(map(int, input().split()))
    cur = num[N - 1]
    buy = 0
    for i in range(N - 1, 0, -1):
        if num[i - 1] >= cur:
            cur = num[i - 1]
        else:
            buy += cur - num[i - 1]
    print("#{} {}".format(tc + 1, buy))