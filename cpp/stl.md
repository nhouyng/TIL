# STL
### vector
```c++
#include <vector>

vector<int> vec;

vec.push_back();

vector<int>::iterator iter;
for(iter = vec.begin();iter != vec.end(); iter++) {
  printf("%d\n", (\*iter));
}
```
#### vector & pair
```c++
#include <vector>
#include <utility>

vector<pair<int, int> > vec;

vector.push_back(make_pair(a, b));
```
#### vector & sort
```c++
#include <vector>
#include <algorithm>

sort(vec.begin(), vec.end());

sort(vec.begin(), vec.end(), comp);
```
#### vector & string
```c++
#include<vector>
#include<string>

vector<string> vec;

char c[11];
scanf("%s", c);
string tmp(c);
vec.push_back(tmp)

vector<string>::iterator iter;
for(iter = vec.begin(); iter != vec.end(); iter++) {
  printf("%s\n", (\*iter).c_str())
}
```
---
### sort
#### algorithm & functional
```c++
#include <algorithm>
#include <functional>

sort(arr, arr+arr_size);                  // default asc
sort(arr, arr+arr_size, less<int>());     // asc using functional
sort(arr, arr+arr_size, greater<int>());  // desc using functional

// 정렬 종류
sort(arr, arr + n, less<int>());
// stable_sort(begin, end);
//정렬 결과가 안정적이다.
stable_sort(arr, arr + n);
// nth_element(begin, begin+k, end
// 정렬된 k위치 값을 얻을 수 있다. (arr는 정렬되지 않는다.)
nth_element(arr, arr + k - 1, arr + n);
// partial_sort(begin, begin+k, end)
// begin 부터 k까지만 부분 정렬한다.
partial_sort(arr, arr + k, arr + n);
```
---
