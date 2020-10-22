#include<iostream>
using namespace std;
int main(){
	int i,j,*num,n;	
	bool flag = true;
	cin>>n;
	num = new int[n];
	for(int i=0;i<n;i++)
		cin>>num[i];
	for(int i=1;i<=n;i++){	
		flag = false;		
		for(int j=0;j<n-1;j++){
			if(num[j]>num[j+1]){
				int temp = num[j];
				num[j] = num[j+1];
				num[j+1] = temp;
				flag = true;
			}
		}
		if(!flag)
			break;		
	}
	for(int i=0;i<n;i++)
		cout<<num[i]<<" ";
	return 0; 
	
}
