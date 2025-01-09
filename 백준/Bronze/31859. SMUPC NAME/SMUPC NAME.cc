#include<iostream>
#include<vector>
#include<string>
#include<algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	int inum,count = 0;
	string snum,tmp, result;
	vector<int>alpha(26, 0);

	// 입력 받기
	cin >> inum >> tmp;
	

	// 중복 제거
	for (int i = 0; i < tmp.size(); i++) {
		if (!alpha[tmp[i] - 'a']) {
			result += tmp[i];
			alpha[tmp[i] - 'a']++;
		}
		else {
			count++;
		}
	}
	// 버린 알파벳 숫자 + 4 붙이기
	count += 4;
	result += to_string(count);
	
	// 출전 등록 번호에 1906을 더한 값 붙이기
	inum += 1906;
	snum += to_string(inum);
	snum += result;
	result = snum;
		
	// 문자열 뒤집기
	reverse(result.begin(), result.end());

	// smupc 붙이기
	string a = "smupc_";
	a += result;
	result = a;
	cout << result;
}