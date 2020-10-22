#include<iostream>
using namespace std;
int main()
{
	//数学处理-没4的很好算
	//int res = 8*9*9*9*9;
	//cout<<res;
	int count,res,a,component;
	int inf=0;
	count = 99999-10000+1;
	for(int i=10000;i<=99999;i++)
	{
		a = i;
		while(a>0)
		{
			component = a%10;
			if(component == 4)
			{
				inf++;
				break;
			}
			a /= 10;
		}
	}
	res = count- inf;
	cout<<res;
	return 0;
}
