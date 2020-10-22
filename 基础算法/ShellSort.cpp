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
					break;//��Ϊʵ����Step�����Ǵ�ǰ����������������һ������ı�ǰ��Ĵ�
					//�Ͳ�����ǰ��������ˣ�ǰ���Ѿ��ź����������				
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
