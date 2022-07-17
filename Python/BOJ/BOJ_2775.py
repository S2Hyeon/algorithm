def init(apartment, k, n):

    for i in range(k):
        apartment[i][0] = 1

    for i in range(1, n):
        apartment[0][i] = i + 1


t = int(input())

for tc in range(t):
    k = int(input()) + 1
    n = int(input())
    apartment = [[0 for i in range(n)] for j in range(k)]
    init(apartment, k, n)

    for i in range(1, k):
        for j in range(1, n):
            apartment[i][j] = apartment[i - 1][j] + apartment[i][j - 1]

    print(apartment[k - 1][n - 1])

# # better idea
#
# import sys
# input = sys.stdin.readline
#
# for _ in range(int(input())):
#     k = int(input())
#     n = int(input())
#
#     people = [i for i in range(n + 1)]
#
#     for i in range(k):
#         for j in range(1, n + 1):
#             people[j] = people[j] + people[j - 1]
#
#     print(people[-1])
