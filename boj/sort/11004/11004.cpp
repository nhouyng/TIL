#include <cstdio>
#include <algorithm>
#include <functional>
using namespace std;

int arr[5000000];

int main(void) {

	int n, k;
	scanf("%d %d", &n, &k);
	for (int i = 0; i < n; i++)
		scanf("%d", &arr[i]);

	//sort(arr, arr + n, less<int>());
	stable_sort(arr, arr + n);
	//nth_element(arr, arr + k - 1, arr + n);
	//partial_sort(arr, arr + k, arr + n);

	/*
	for (int i = 0; i < n; i++)
		printf("[%d]", arr[i]);
	printf("\n");
	*/
	printf("%d", arr[k - 1]);
}