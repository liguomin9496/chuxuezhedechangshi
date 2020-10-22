#include<iostream>
using namespace std;
int main()
{
	int sum=1;
	int temp = 1;
	for(int i=2;i<101;i++)
	{
		temp = temp+i;
		sum += temp;
	}
	cout<<sum;
	return 0;
}