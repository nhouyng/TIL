n, k = map(int, input().split())
arr = list(map(int, input().split(sep=" ")))
arr.sort()
print(arr[k-1])
