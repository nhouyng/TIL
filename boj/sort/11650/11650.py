size = int(input())
arr = []
for i in range(size):
    a, b = map(int, input().split())
    arr.append([a, b])
arr.sort()
for i in range(size):
    print(*arr[i], sep=' ')