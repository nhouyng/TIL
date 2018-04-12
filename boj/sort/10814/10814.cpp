#include <cstdio>
#include <vector>
#include <utility>
#include <algorithm>
#include <string>
using namespace std;

vector<pair<int, int> > vec;
string names[100001];

int main(void) {

	int size;
	scanf("%d", &size);

	for (int i = 0; i < size; i++) {
		int age;
		char c[101];
		scanf("%d %s", &age, c);
		string str(c);
		names[i] = str;
		vec.push_back(make_pair(age, i));
	}

	stable_sort(vec.begin(), vec.end());

	for (int i = 0; i < vec.size(); i++) {
		printf("%d %s\n", vec[i].first, names[vec[i].second].c_str());
	}
}