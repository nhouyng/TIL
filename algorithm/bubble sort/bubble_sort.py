def bubble_sort(arr):
    for i in range(len(arr) - 1):
        for j in range(len(arr) -1 -i):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]
    return arr

size = int(input())
arr = []
for i in range(size):
    arr.append(int(input()))

print(arr)
arr = bubble_sort(arr)
print(arr)