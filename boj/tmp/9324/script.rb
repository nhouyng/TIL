t = Integer(gets.chomp)
t.times {
  arr = Array.new(26, 0)
  str = gets.chomp
  str.split("")
  flag = true
  i = 0
  while i < str.length
    idx = str[i].ord - 65
    arr[idx]+=1

    if arr[idx]%3==0
      if i+1 == str.length or str[i] != str[i+1]
        flag = false
        break
      else
        i+=1
      end
    end
    i+=1
  end

  if flag
    puts "OK"
  else
    puts "FAKE"
  end
}
