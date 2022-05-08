T = 10
for tc in range(T):
    width = int(input())
    building = list(map(int, input().split()))
    result = 0
    for i in range(2, width - 2):
        maxHeight = max(building[i - 2], building[i - 1], building[i + 1], building[i + 2])

        if building[i] > maxHeight:
            result += building[i] - maxHeight

    print("#{} {}".format(tc + 1, result))