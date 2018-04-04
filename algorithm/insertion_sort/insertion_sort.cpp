#include <cstdio>
using namespace std;

int* insertion_sort(int *arr, int size);

int main(void) {

	int size;
	scanf("%d", &size);

	int* arr = new int[size];

	for (int i = 0; i < size; i++)
		scanf("%d", &arr[i]);

	for (int i = 0; i < size; i++)
		printf("[%d]", arr[i]);
	printf("\n");

	arr = insertion_sort(arr, size);

	for (int i = 0; i < size; i++)
		printf("[%d]", arr[i]);
}

int* insertion_sort(int *arr, int size) {

	for (int i = 0; i < size; i++) {
		int value = arr[i];
		int index = i;

		while (index > 0 && value < arr[index - 1]) {
			arr[index] = arr[index - 1];
			index--;
		}
		arr[index] = value;
	}

	return arr;
}