#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
	ll n;
	cin >> n;
	ll end = sqrt(LLONG_MAX), start = 0, center = 0;
	while (start <= end) {
		center = (start + end) / 2;
		if (center * center > n) {
			end = center - 1;
		}
		else if (center * center < n) {
			start = center + 1;
		}
		else {
			cout << center;
			return 0;
		}
	}
	cout << start;
}