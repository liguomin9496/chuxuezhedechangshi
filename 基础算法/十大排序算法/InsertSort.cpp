#include<iostream>
using namespace std;//Ĭ�ϴ���һ���Ѿ��źõ����飬����������ֻ���ҵ���ȷ��λ�ã�Ȼ������ȥ��Ҫ��������������е�λ�þ����ƶ���Ҫ��һ����λ 
void InsertSort(int nums[],int n){//��С��������� 
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
 
