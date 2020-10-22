#include<iostream>
#include<vector> 
using namespace std;
int cnt=0;
vector<int>number;
void Search(int n,int k){
	for(int i=0;i<n;i++)
		if(number[i]%k == 0)
			cnt++;
	for(int m=2;m<=n;m++){//形成K倍空间的数可能有1个~N个，依次试探 
		for(int i=0;i<n;i++){//尺头 
			int sum=0;
			int count=0;
			bool flag = false;
			for(int j=i;j<i+m && j<n;j++){//尺尾 
				count++;
				if(count<m)//保证有m个数参与了求和 
					flag = false;
				else
					flag = true;
				sum += number[j];
			}
		if(sum%k == 0)
			if(flag)
				cnt++;
		}
	}
}
int main(){
	int n,k;
	cin>>n>>k;
	for(int i=0;i<n;i++){
		int temp;
		cin>>temp;
		number.push_back(temp);
	}	
	Search(n,k);
	cout<<cnt<<endl;
	return 0;
}
