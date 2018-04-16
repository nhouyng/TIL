#include <cstdio>
using namespace std;

int main(void) {

	int n;
	scanf("%d", &n);

	int* prime = new int[n+1];
	prime[0] = prime[1] = 0;
	for (int i = 2; i <= n; i++)
		prime[i] = i;

	for (int i = 2; i <= n; i++) {
		if (!prime[i]) continue;
		for (int j = i * 2; j <= n; j += i)
			prime[j] = 0;
	}

	for (int i = 0; i <= n; i++) {
		if(prime[i])
			printf("%d ", prime[i]);
	}
}