def insertion_sort(arr):
    for i in range(len(arr)):
        value = arr[i]
        index = i
        while index > 0 and value < arr[index-1]:
            arr[index] = arr[index-1]
            index = index-1
        arr[index] = value
    return arr

size = int(input())
arr = []
for i in range(size):
    arr.append(int(input()))
print(*arr, sep=",")
arr = insertion_sort(arr)
print(*arr, sep=",")