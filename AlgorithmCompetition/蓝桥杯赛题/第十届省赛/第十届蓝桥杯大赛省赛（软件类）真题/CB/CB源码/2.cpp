#include<iostream>
using namespace std;
int main()
{
	int a = 26*27;	
	int b = 2019;
	int sum;
	for(int i=1;i<=26;i++)
	{
		sum = a;
		sum += i*26*26;
		if(sum >= b)
		{		
			cout<<i<<endl;
			cout<<sum<<endl;
			break;			
		}
	}
	return 0;
}/*BYQ*/
