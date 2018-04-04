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
