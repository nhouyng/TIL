size = int(input())
s = []
for i in range(size):
    a, b = input().split(sep=" ")
    s.append([int(a), b, i])

def f(s):
    return (s[0], s[2])
s.sort(key=f)
for i in range(size):
    print(str(s[i][0])+" "+s[i][1])