#include <cstdio>
using namespace std;

int* bubble_sort(int* arr, int size);

int main(void) {

	int size;
	scanf("%d", &size);

	int* arr = new int[size];
	for (int i = 0; i < size; i++) {
		scanf("%d", &arr[i]);
	}

	for (int i = 0; i < size; i++)
		printf("[%d]", arr[i]);
	printf("\n");

	arr = bubble_sort(arr, size);

	for (int i = 0; i < size; i++)
		printf("[%d]", arr[i]);
}

int* bubble_sort(int* arr, int size) {

	for (int i = 0; i < size - 1; i++) {
		for (int j = 0; j < size - 1 - i; j++) {
			if (arr[j] > arr[j + 1]) {
				int tmp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = tmp;
			}
		}
	}

	return arr;
}