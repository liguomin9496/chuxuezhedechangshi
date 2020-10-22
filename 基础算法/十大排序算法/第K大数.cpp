#include<iostream>//从大到小的快排  
using namespace std;
int partition(int num[],int start,int end){
	int left=start;
	int right = end;
	int pivot = num[start];
	while(left<right){
		while((right>left)&&(num[right]) <= pivot)//右边找大的 
			right--;
		num[left] = num[right];
		while((left<right)&&num[left] >= pivot)//从左边找小的 
			left++;
		num[right] = num[left];
	}
	num[left] = pivot;
	return left;	
}
void find_K(int num[],int k,int start,int end){
	if(start<=end){//注意这里是小于等于 
		int pivot_k = partition(num,start,end);
		if((pivot_k+1-start) == k){
			cout<<num[pivot_k]<<endl;
			return;
		}
		else if((pivot_k+1-start) > k)
			find_K(num,k,start,pivot_k-1);
		else
			find_K(num,k-(pivot_k-start+1),pivot_k+1,end);
	}
}

int main(){
	int num[11]={6,5,3,8,1,9,4,45,36,32,11};
	find_K(num,8,0,10);
	for(int i=0;i<10;i++)
		cout<<num[i]<<" ";
	return 0;	
} 
