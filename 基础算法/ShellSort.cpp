#include<iostream>
using namespace std;
void ShellSort(int num[],int length){
	int step = length >> 1;
	while(step >= 1){
		for(int i=step;i<length;i++){
			for(int j=i;j>=step;j -= step){
				if(num[j] < num[j-step]){
					int temp = num[j];
					num[j] = num[j-step];
					num[j-step] = temp;					
				}
				else
					break;//因为实现里Step分组是从前面往后面排序，所以一旦后面的比前面的大
					//就不用往前面继续排了，前面已经排好了是有序的				
			}
		}
		step >>= 1;
	}	
}
int main(){
	int n,*num;
	cin>>n;
	num = new int[n];
	for(int i=0;i<n;i++)
		cin>>num[i];
	ShellSort(num,n);
	for(int i=0;i<n;i++)
		cout<<num[i]<<"  ";
	cout<<endl;
	return 0;	
} 
