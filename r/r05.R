#
# 05-1 데이터 파악
#

exam <- read.csv("csv_exam.csv")
head(exam)
head(exam, 10)
tail(exam)
tail(exam, 10)

# View() 뷰어창에서 데이터 확인
View(exam)
View(head(exam,3))

# 결과 = "행 cnt" "열 cnt"
dim(exam)
# 속성 보기
str(exam)
# 요약 통계량
summary(exam)
# Min. = 최솟값
# 1st Qu = 1사분위수(하위 25% 지점에 위치하는 값)
# Median = 중앙값
# Mean = 평균
# 3rd Qu = 3사분위수(하위 75% 지점에 위치하는 값)
# Max. = 최댓값
# 해석 : 중앙값(Median) 기준으로 여기(1st Qu)와 여기(3rd Qu)사이에 몰려있다

# mpg 데이터 분석해보기!!!
mpg <- as.data.frame(ggplot2::mpg)
head(mpg)
tail(mpg)
View(mpg)
dim(mpg)
str(mpg)
summary(mpg)


#
# 05-2 변수명 바꾸기
#
# console > install.packages("dplyr")
library(dplyr)

df_raw <- data.frame(var1=c(1,2,1),var2=c(2,3,2))
df_new <- df_raw
df_new <- rename(df_new, v2 = var2)

mpg_new <- rename(mpg, city = cty, highway = hwy)
head(mpg_new)


#
# 05-3 파생변수
#
df <- data.frame(var1 = c(4,3,8),var2=c(2,6,1))
df$var_sum <- df$var1 + df$var2
df$var_mean <- (df$var1 + df$var2)/2
mpg$total <- (mpg$cty + mpg$hwy)/2
head(mpg)
mean(mpg$total)
summary(mpg$total)
hist(mpg$total)

# ifelse(1.조건, 2.true, 3.false)
mpg$test <- ifelse(mpg$total >= 20,"pass","fail")
head(mpg)
# 빈도 표시 뭐가 몇개씩
table(mpg$test)
library(ggplot2)
qplot(mpg$test)
# 중첩 반복문
mpg$grade <- ifelse(mpg$total >= 30,'A',ifelse(mpg$total<20, 'C','B'))
head(mpg, 20)