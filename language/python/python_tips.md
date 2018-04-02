# Python tips
### setted key
- pycharm 컴파일 && 실행 : alt + shift + f10
- pycharm 실행 : shift + f10
- pycharm 자동 정렬 단축키 : alt + ctrl + i
---
- input
'변수명 = input()'을 통해 입력을 받는다. 다만 문자열로 인식하기 때문에 정수를 입력받기 위해서는 input를 형변환 해야함
```python
# 들어 오는 input은 모두 문자열
str = input()
# 형변환을 통해 정수형 입력을 수행
num = int(input())
```
---
- print
'print(변수)'를 통해 출력한다. 배열도 변수 부분에 넣고 출력하면 모든 인덱스에 대한 값이 나옴
---
- 함수 정의
def 함수이름(매개변수):
  함수 수행 코드
  return value;
---
- for 반복문
range(변수) 메소드는 변수를 0~length 까지의 길이의 배열로 반환하는 메서드이다. range(start, end)로 사용할 수 있다.
```python
for i in range(length):
```
---
- swap
주석처리 된 부분은 c++, java에서 주로 사용하는 일반적인 swap방식, python은 일반적인 swap방식 말고도 아래 한줄로 swap을 해버림;
```Python
# temp = arr[i]
# arr[i] = arr[index]
# arr[index] = temp
arr[i], arr[index] = arr[index], arr[i]
```
---
- 배열
```python
array = []
for i in range(length):
    array.append(int(input()));
```
