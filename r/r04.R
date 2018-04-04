#
# 04-1 data frame
#


#
# 04-2 data frame 만들기
#
english <- c(90,80,60,70)
math <- c(50,60,100,20)
df_midterm <- data.frame(english, math)

class <- c(1,1,2,2)
df_midterm <- data.frame(english, math, class)

mean(df_midterm$english)
mean(df_midterm$math)

# 한번에 만들때 <- 아닌 = 를 쓴다.
df_midterm <- data.frame(english = c(90,80,60,70), math = c(50,60,100,20), class = c(1,1,2,2))

# Q1
q1_name = c("사과","딸기","수박")
q1_price = c(1800,1500,3000)
q1_sell = c(24,38,13)
df_q1 = data.frame(q1_name, q1_price, q1_sell)


#
# 04-3 외부 데이터
#
# console > install.packages("readxl")
# excel file
library(readxl)
df_exam <- read_excel("excel_exam.xlsx")
mean(df_exam$english)
mean(df_exam$science)
# 엑셀 첫 행이 변수명이 아니고 바로 data 일 경우
df_exam_novar <- read_excel("excel_exam_novar.xlsx")
df_exam_novar <- read_excel("excel_exam_novar.xlsx", col_names = F)
# 엑셀 파일이 여러 시트가 존재할때
df_exam_sheet <- read_excel("excel_exam_sheet.xlsx", sheet = 3)


# csv file (별도의 패키지가 필요없음)
df_csv_exam <- read.csv("csv_exam.csv")
# 문자 타입 factor -> chr로 변환하면서 불러야한다.
df_csv_exam <- read.csv("csv_exam.csv", stringsAsFactors = F)

# dataframe을 csv파일로 저장하기
df_midterm
write.csv(df_midterm, file = "df_midterm.csv")

# rdata (.rda || .rdata) file
# data frame을 rdata 파일로 저장하기
save(df_midterm, file="df_midterm.rda")

# rdata file 불러오기
rm(df_midterm)
df_midterm
load("df_midterm.rda")