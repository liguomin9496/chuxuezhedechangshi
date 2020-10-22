#include<iostream>//二分查找插入排序(从小到大) 
using namespace std;
void InsertSort(int nums[],int n){
	for(int i=1;i<n;i++){
		if(nums[i-1]>nums[i]){
			int low = 0;
			int high = i-1;
			int temp = nums[i];
			while(high>=low){
				int mid = (high+low) >> 1;
				if(nums[mid]>temp)
					high = mid - 1;
				else
					low = mid + 1;				
			} 
			for(int j=i;j>low;j--)
				nums[j] = nums[j-1];//后移大值
			nums[low] = temp; 
		}
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
