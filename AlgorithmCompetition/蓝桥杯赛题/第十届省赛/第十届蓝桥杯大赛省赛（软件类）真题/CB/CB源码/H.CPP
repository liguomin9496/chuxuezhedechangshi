#include<iostream>
using namespace std;
int max1=0,minDis=100;
void Seek(int num[],int n)
{
	int distance;
	max1 = num[0];
	for(int i=1;i<n;i++)
	{
		distance = num[i] - num[i-1];
		if(num[i]>max1)
			max1 = num[i];		
		if(distance<minDis)		
			minDis = distance;			
	}
}
int main()
{
    int n,result=0,*num;
	cin>>n;
	num = new int[n];
	for(int i=0;i<n;i++)
		cin>>num[i];
	Seek(num,n);
	if(max1%minDis == 0)
		result = max1/minDis;
	else
		result = (max1/minDis)+1;
	cout<<result<<endl;
	return 0;
}
