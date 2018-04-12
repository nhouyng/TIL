#include <cstdio>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool comp(const string &s1, const string &s2) {
	if (s1.length() == s2.length()) {
		return s1 < s2;
	}
	return s1.length() < s2.length();
}

int main(void) {

	int size;
	scanf("%d", &size);

	vector<string> vec;
	for (int i = 0; i < size; i++) {
		char c[51];
		scanf("%s", c);
		string str(c);
		vec.push_back(str);
	}

	sort(vec.begin(), vec.end(), comp);
	vector<string>::iterator iter;
	string tmp = "";
	for (iter = vec.begin(); iter != vec.end(); iter++) {
		if (tmp == (*iter).c_str())
			continue;
		printf("%s\n", (*iter).c_str());
		tmp = (*iter).c_str();
	}
}