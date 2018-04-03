size = int(input())
s = []
for i in range(size):
    s.append(input())
s = list(set(s))
s = sorted(s)
s.sort(key=len)
print(*s, sep='\n')
