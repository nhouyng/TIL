n = int(input())
l = []
for i in range(n):
    a, b = map(int, input().split())
    l.append([b, a])
l.sort()
for i in range(n):
    print(str(l[i][1])+" "+str(l[i][0]))