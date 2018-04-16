n = int(input())
l = []
l.append(0)
l.append(0)
for i in range(2, n + 1):
    l.append(i)
print(l)
for i in range(2, n + 1):
    if l[i] == 0:
        continue
    j = i * 2
    while j <= n:
        l[j] = 0;
        j = j + i
print(l)