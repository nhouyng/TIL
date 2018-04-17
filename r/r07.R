#
# 07-1 결측치 정제
#
df <- data.frame(sex = c("M","F",NA,"M","F"),
                 score = c(5,4,3,4,NA))
# 결측치 확인
is.na(df)

# 결측치 빈도 출력
table(is.na(df))
table(is.na(df$sex))
table(is.na(df$score))

# 결측치 때문에 NA출력 된다.
mean(df$score)
sum(df$score)

# 결측치 제거 (filter)
library(dplyr)
df %>% filter(is.na(score))
df %>% filter(!is.na(score))

df_nomiss <- df %>% filter(!is.na(score))
mean(df_nomiss$score)
sum(df_nomiss$score)

df_nomiss <- df %>% filter(!is.na(score) & !is.na(sex))

# 결측치 제거 (omit)
df_nomiss2 <- na.omit(df)

# 결측치  견제 (na.rm)
mean(df$score, na.rm = T)
sum(df$score, na.rm = T)

# 예제 데이터 만들기
exam <-read.csv("csv_exam.csv")   # 데이터 불러오기
exam[c(3, 8, 15), "math"] <- NA   # 3, 8, 15행의 math에 NA 할당

exam %>% summarise(mean_math = mean(math))
exam %>% summarise(mean_math = mean(math, na.rm = T))
exam %>% summarise(mean_math = mean(math, na.rm = T),
                   sum_math = sum(math, na.rm = T),
                   median_math = median(math, na.rm = T))

# 결측치 대체하기
# 평균값으로 결측치 대체하기
mean(exam$math, na.rm = T)
exam$math <- ifelse(is.na(exam$math), 55, exam$math)
table(is.na(exam$math))
mean(exam$math)



#
# 07-2 이상치 정제
#
# sex(male = 1, female = 2)
# score(1~5)
outlier <- data.frame(sex = c(1,2,1,3,2,1),
                      score = c(5,4,3,4,2,6))
# 이상치 확인하기
table(outlier$sex)
table(outlier$score)

# 이상치를 결측으로 처리
outlier$sex <- ifelse(outlier$sex == 3, NA, outlier$sex)
outlier$score <- ifelse(outlier$score > 5, NA, outlier$score)

outlier %>% 
  filter(!is.na(sex) & !is.na(score)) %>% 
  group_by(sex) %>% 
  summarise(mean_score = mean(score))

# 극단치; 논리적으로 존재하나 극단적으로 크거나 작은 값
# 상자 그림으로 극단치 기준 정하기
boxplot(mpg$hwy)
boxplot(mpg$hwy)$stats # [1,](12) ~ [5,1](37)을 벗어나면 극단치로 분류

mpg$hwy <- ifelse(mpg$hwy < 12 | mpg$hwy > 37, NA, mpg$hwy)
table(is.na(mpg$hwy))

mpg %>% 
  group_by(drv) %>% 
  summarise(mean_hwy = mean(hwy, na.rm = T))