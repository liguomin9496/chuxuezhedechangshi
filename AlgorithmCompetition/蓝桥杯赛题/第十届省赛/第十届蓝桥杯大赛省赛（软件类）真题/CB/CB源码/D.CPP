#include<iostream>
using namespace std;
int a[3]={0,0,0};
int ress = 0;
bool check()
{
	if((a[0]+a[1]+a[2]) == 2019)
		return true;
	return false;
}
bool checkNum(int num)
{
	while(num >0)
	{
		int b = num %10;
		if(b == 2 || b == 4)
			return true;
		num = num/10;
	}
	return false;
}
void dfs(int step,int k)
{
	if(step > 2)
	{
		if(check())			
			ress++;		
		return;
	}
	for(int i=1;i<=k;i++)
	{
		if(checkNum(i))
			continue;
		else
		{
			if(step == 1)
			{
				if(i == a[0])
					continue;
			}
			if(step == 2)
			{
				if(i == a[0] || i == a[1])
					continue;
			}
			a[step] = i;
			dfs(step+1,k);
		}
	}
	return ;
}
int main()
{
	int k = 2019;
	int step = 0;
	dfs(step,k);
	cout<<ress/6<<endl;//不同的3个数的组合顺序有6种，所以在这儿/6；  
	return 0;
}               
