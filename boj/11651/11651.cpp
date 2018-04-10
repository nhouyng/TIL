#include <cstdio>
#include <vector>
#include <utility>
#include <algorithm>
using namespace std;

vector<pair<int, int> > vec;

int main(void) {

	int n;
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		int a, b;
		scanf("%d %d", &a, &b);
		vec.push_back(make_pair(b, a));
	}

	sort(vec.begin(), vec.end());

	for (int i = 0; i < vec.size(); i++) {
		printf("%d %d\n", vec[i].second, vec[i].first);
	}
}