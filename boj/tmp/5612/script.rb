times = Integer(gets.chomp)
now = Integer(gets.chomp)
max = 0
flag = true
for i in 1..times
  tmp = gets.chomp.split(" ")
  now += Integer(tmp[0])
  now -= Integer(tmp[1])
  if now < 0
    flag = false
    break
  end

  if now > max
    max = now
  end
end

if flag
  print max
else
  print 0
end
