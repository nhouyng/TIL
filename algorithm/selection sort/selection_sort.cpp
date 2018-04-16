#include <cstdio>
using namespace std;

int* selectionSort(int *arr, int size);

int main(void) {
	int size;
	scanf("%d", &size);

	int *arr = new int[size];

	for (int i = 0; i < size; i++)
		scanf("%d", &arr[i]);

	for (int i = 0; i < size; i++) {
		printf("[%d]", arr[i]);
	}
	printf("\n");

	arr = selectionSort(arr, size);

	for (int i = 0; i < size; i++) {
		printf("[%d]", arr[i]);
	}
	printf("\n");

	delete[]arr;
}

int* selectionSort(int *arr, int size) {

	for (int i = 0; i < size; i++) {
		int index = i;
		for (int j = i + 1; j < size; j++) {
			if (arr[index] > arr[j]) {
				index = j;
			}
		}

		int temp = arr[i];
		arr[i] = arr[index];
		arr[index] = temp;
	}

	return arr;
}