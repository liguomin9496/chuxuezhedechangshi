#include<iostream>
#include<vector> 
using namespace std;
int cnt=0;
vector<int>number;
void Search(int n,int k){
	for(int i=0;i<n;i++)
		if(number[i]%k == 0)
			cnt++;
	for(int m=2;m<=n;m++){//�γ�K���ռ����������1��~N����������̽ 
		for(int i=0;i<n;i++){//��ͷ 
			int sum=0;
			int count=0;
			bool flag = false;
			for(int j=i;j<i+m && j<n;j++){//��β 
				count++;
				if(count<m)//��֤��m������������� 
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
