T = int(input())
for tc in range(T):
    tcNum = int(input())
    inputArr = list(map(int, input().split()))
    arr = [0] * 101
    for i in range(len(inputArr)):
        arr[inputArr[i]] += 1
    m = max(arr)
    result = [i for i, v in enumerate(arr) if v == m]
    print("#{} {}".format(tcNum, result[-1]))
