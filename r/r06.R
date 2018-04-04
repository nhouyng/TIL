#
# 06-1 조건 filter
#
library(dplyr)
exam <- read.csv("csv_exam.csv")

# exam에서 class가 1인 경우만 추출해 출력
# ctrl + shift + m 입력하면 %>% 자동완성
exam %>% filter(class == 1)
exam %>% filter(class != 1)
exam %>% filter(math > 50)
exam %>% filter(class == 1 & english >= 80)
exam %>% filter(math >= 90 | english >= 90)
exam %>% filter(class %in% c(1,3,5))

class1 <- exam %>% filter(class == 1)
class2 <- exam %>% filter(class == 2)

# 산술 연산자
# 제곱(^, **)
# 나눗셈의 몫(%/%)
# 나눗셈의 나머지(%%)


#
# 06-2 변수 추출
#
exam %>% select(math)
exam %>% select(english)
exam %>% select(class, math, english)
# 변수 제외
exam %>% select(-math)
exam %>% select(-math, -english)
# dplyr 조합
exam %>% filter(class == 1) %>% select(english)
exam %>% select(id, math) %>% head
exam %>% select(id, math) %>% head(10)


#
# 06-3 정렬
#
exam %>% arrange(math)
exam %>% arrange(desc(math))
exam %>% arrange(class, math)


#
# 06-4 파생변수 추가
#
exam %>% mutate(total = math + english + science) %>% head
exam %>% mutate(total = math + english + science, mean =(math + english + science)/3) %>% head
exam %>% mutate(test = ifelse(science >= 60,"pass","fail")) %>% head
exam %>% mutate(total = math + enlish + science) %>% arrange(total) %>% head


#
# 06-5 집단별 요약
#
exam %>% summarise(mean_math = mean(math))
exam %>% group_by(class) %>% summarise(mean_math = mean(math))
exam %>% group_by(class) %>% summarise(mean_math = mean(math),
                                       sum_math = sum(math),
                                       median_math = median(math),
                                       n = n())
# mean() 평균
# sd() 표준편차
# sum() 합계
# median() 중앙값
# min() 최솟값
# max() 최댓값
# n() 빈도

mpg %>% group_by(manufacturer, drv) %>% summarise(mean_cty = mean(cty)) %>% head(10)

mpg %>% 
  group_by(manufacturer) %>% # 회사별로 분리
  filter(class == "suv") %>% # suv 추출
  mutate(tot = (cty+hwy)/2) %>% # 통합 연비 변수 생성
  summarise(mean_tot = mean(tot)) %>% # 통합 연비 평균 산출
  arrange(desc(mean_tot)) %>% # 내림차순 정렬
  head(5)


#
# 06-6 데이터 합치기
#
test1 <- data.frame(id = c(1,2,3,4,5), midterm = c(60,80,70,90,85))
test2 <- data.frame(id = c(1,2,3,4,5), midterm = c(70,83,65,95,80))
total <- left_join(test1, test2, by="id")

name <- data.frame(class = c(1,2,3,4,5), teacher = c("kim","lee","park","choi","jung"))
exam_new <- left_join(exam, name, by="class")

# 세로 합치기
group_a <- data.frame(id =c(1,2,3,4,5), test=c(60,80,70,90,85))
group_b <- data.frame(id =c(6,7,8,9,10), test=c(70,83,65,95,80))
group_all <- bind_rows(group_a, group_b)
# stringAsFactors는 factor로 들어오는 값을 chr로 변환
fuel <- data.frame(f1 = c("c","d","e","p","r"), price_fl = c(2.35,2.38,2.11,2.76,2.22), stringsAsFactors = F)