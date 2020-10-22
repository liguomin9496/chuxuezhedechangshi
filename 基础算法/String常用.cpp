#include<iostream>
#include<string>
#include <algorithm>
using namespace std;
int main(){
	string str = "liguominhaiying";
	for(int i=0;i<str.size();i++){
		cout<<str[i]<<"  ";
	}
	cout<<endl;	
	string strs[2] = {"liguominhaiying","hcgwduyeg"};
	string str1 = strs[0];
	char str2 = strs[0][0];
	cout<<str1<<endl;
	cout<<str2<<endl;
	int count = 9496;
	str1 += to_string(count);//(C++11开始支持)
	cout<<str1<<endl;
	sort(str.begin(),str.end());	
	cout<<str<<endl;
	return 0;
} 
