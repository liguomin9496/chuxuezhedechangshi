#include<iostream>
using namespace std;
int tier = 1;
void Tier(int n)
{
	int sum1=1;
	int temp = 1;
	if(n == 1)
		return; 
	for(int i=1;i<=100;i++)
	{
		temp *= 2;
		sum1 += temp;
		if(sum1 == n)
		{
			tier = i+1;
			break;
		}
	}
	return;
}
void CoutMax(int SumTier[])
{
	int max=SumTier[0];
	for(int i=1;i<tier;i++)
	{
		if(SumTier[i]>max)//只有大于现阶段的最大值才会交换值以及，下面的循环匹配可以输出最大值的最小层 
			max = SumTier[i];
	}
	for(int i=0;i<tier;i++)
		if(max == SumTier[i])
		{
			cout<<i+1<<endl;
			break;
		}	
}
void Sum(int num[],int SumTier[])
{
	int start=0,end=0;
	int sum2=1; 
	SumTier[0]=num[0];
	for(int i=1;i<tier;i++)
	{
		int sum3=0;
		sum2 *= 2;
		start = end + 1;
		end += sum2;
		for(int j=start;j<=end;j++)		
			sum3 += num[j];
		SumTier[i] = sum3;
	}
}
int main()
{
	int *num,n;
	num = new int [n];
	cin>>n;
	for(int i=0;i<n;i++)
		cin>>num[i];
	Tier(n);	
	cout<<tier<<endl;
	int *SumTier;
	SumTier = new int[tier];
	Sum(num,SumTier);
	CoutMax(SumTier);
	for(int i=0;i<tier;i++)
		cout<<SumTier[i]<<"  ";
	return 0;
}
