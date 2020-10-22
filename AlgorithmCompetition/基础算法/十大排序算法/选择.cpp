#include<iostream>
using namespace std;
int main() {
	int i,j,n,*num;
	cin>>n;
	num = new int[n];
	for(int i=0;i<n;i++)
		cin>>num[i];
	for(int i=0;i<n;i++)
		for(int j=i;j<n;j++){
			if(num[i]>num[j]){
				int temp = num[i];
				num[i] = num[j];
				num[j] = temp;
			}
		}
	for(int i=0;i<n;i++)
		cout<<num[i]<<" ";			 
	return 0;	
}
