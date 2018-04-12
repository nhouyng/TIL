#include <cstdio>
#include <vector>
#include <algorithm>
#include <utility>
using namespace std;

int main(void) {

	int size;
	scanf("%d", &size);

	vector<pair<int, int> > vec;

	for (int i = 0; i < size; i++) {
		int a, b;
		scanf("%d %d", &a, &b);
		vec.push_back(make_pair(a, b));
	}

	sort(vec.begin(), vec.end());

	vector<pair<int, int> >::iterator iter;
	for (iter = vec.begin(); iter != vec.end(); iter++) {
		printf("%d %d\n", (*iter).first, (*iter).second);
	}
}