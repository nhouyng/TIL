#
# 03-1 변수
#
var1 <- c(1,2,3,4,5)
var2 <- c(1:5)
var3 <- seq(1,5)
var4 <- seq(1, 10, by = 2)

var1+2
var1+var2

str1 <-"a"
str2 <- "text"
str3 <- "Hello World"
str4 <- c("a","b","c")
str5 <- c("Hello!","World","is","good!")

# error chr + numeric
str1+2


#
# 03-2 함수
#
x <- c(1,2,3)
mean(x)
max(x)
min(x)
# 문자열 합치기
# collapse는 단어를 구분할 문자를 지정하는 기능
paste(str5, collapse = ",")
paste(str5, collapse=" ")

x_mean <- mean(x)
str5_paste <- paste(str5, collapse =" ")


#
# 03-3 패키지
#
# console > install.packages("ggplot2")
# 설치도중 lib ~ is not writable 에러발생 -> 관리자 권한으로 실행
library(ggplot2)
x <- c("a","a","b","c")
qplot(x)

qplot(data = mpg, x = hwy)
qplot(data = mpg, x = cty)
qplot(data = mpg, x = drv, y = hwy)
qplot(data = mpg, x = drv, y = hwy, geom = "line")
qplot(data = mpg, x = drv, y = hwy, geom = "boxplot")
qplot(data = mpg, x = drv, y = hwy, geom = "boxplot", colour = drv)

?qplot

stu <- c(80, 60, 70, 50, 90)
stu_mean <- mean(stu)