#include<iostream>
using namespace std;//默认存在一个已经排好的数组，而后来的数只是找到正确的位置，然后插入进去，要插入的数在数组中的位置就是移动需要的一个空位 
void InsertSort(int nums[],int n){//从小到大的排序 
	for(int i=1;i<n;i++){
		int temp = nums[i];
		int j=i;
		for( ;j>0;j--){
			if(temp<nums[j-1])
				nums[j] = nums[j-1];
			else 
				break;	
		}
		nums[j] = temp;
	}
}
int main(){
	int n,*nums;
	cin>>n;
	nums = new int[n];
	for(int i=0;i<n;i++)
		cin>>nums[i];
	InsertSort(nums,n);
	for(int i=0;i<n;i++)
		cout<<nums[i]<<"  ";	
}
 
