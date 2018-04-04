# C++ tips
- visual studio 자동 정렬 단축키 : ctrl + a, ctrl + k + d
---
- 배열 동적 할당
```c++
int main(void) {
	int size;
	scanf("%d", &size);

	int * arr = new int[size];

	for (int i = 0; i < size; i++)
		scanf("%d", &arr[i]);

	for (int i = 0; i < size; i++) {
		printf("[%d]", arr[i]);
	}
	printf("\n");

	delete[]arr;
}
```
