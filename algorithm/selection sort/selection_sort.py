def selection_sort(arr):
    size = len(arr)
    for i in range(size-1):
        index = i
        for j in range(i+1, size):
            if arr[index] > arr[j]:
                index = j
        arr[i], arr[index] = arr[index], arr[i]

    return arr


length = int(input())
array = []
for i in range(length):
    array.append(int(input()));

print(array)
array = selection_sort(array)
print(array)