#include<iostream>
using namespace std;
int main()
{
	int sum;
	int temp=0;
	int i=0;
	while(sum != 0)
	{
		i++;
		temp = i;
		sum = 236;
		for(int j=i;j<=100;j++)
		{
			sum -= j;
			if(sum <= 0)			
				break;
		}
	}
	cout<<temp;
	return 0;
}