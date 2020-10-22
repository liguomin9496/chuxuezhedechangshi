#include<iostream>
using namespace std;
int partition(int num[],int start,int end){
	int left=start;
	int right = end;
	int pivot = num[start];
	while(left<right){
		while((right>left)&&(num[right])>=pivot)//右边找小的 
			right--;
		num[left]=num[right];
		while((left<right)&&num[left]<=pivot)//从左边找大的 
			left++;
		num[right]=num[left];
	}
	num[left]=pivot;
	return left;	
}
void quickSort(int num[],int start,int end){
	if(end>start){
		int split = partition(num,start,end);
		quickSort(num,start,split-1);
		quickSort(num,split+1,end);	
	}
}
int main(){
	int num[11]={6,5,3,8,1,9,4,45,36,32,11};
	quickSort(num,0,10);
	for(int i=0;i<=10;i++)
		cout<<num[i]<<"  ";
	return 0;	
} 
