#include<iostream>
using namespace std;
void Merge(int data[],int left,int center,int right){
	int length = right-left+1;
	int tmpIndex = 0,*tmp;
	tmp = new int[length];
	int s_left = left;
	int s_right = center+1;
	while(s_left <= center && s_right <= right){
		if(data[s_left] <= data[s_right])
			tmp[tmpIndex++] = data[s_left++];
		else
			tmp[tmpIndex++] = data[s_right++];
	}
	while(s_right <= right){
		tmp[tmpIndex++] = data[s_right++];
	}
	while(s_left <= center){
		tmp[tmpIndex++] = data[s_left++];
	}
	tmpIndex = 0;
	while(tmpIndex<length){
		data[left+tmpIndex] = tmp[tmpIndex++];
	}
}
void MergeSort(int data[],int left,int right){
	if(left<right){
		int center = (left+right) >> 1;
		MergeSort(data,left,center);
		MergeSort(data,center+1,right);
		Merge(data,left,center,right);
	}	
}

int main(){
	int *num,n;
	cin>>n;
	num = new int[n];
	for(int i=0;i<n;i++)
		cin>>num[i];
	MergeSort(num,0,n-1); 
	for(int i=0;i<n;i++)
		cout<<num[i]<<"  ";
	return 0;
} 
