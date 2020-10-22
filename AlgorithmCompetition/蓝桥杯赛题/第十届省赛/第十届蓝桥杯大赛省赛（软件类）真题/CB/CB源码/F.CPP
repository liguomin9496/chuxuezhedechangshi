#include<iostream>
using namespace std;
int main()
{
	int n;
	cin>>n;
	int result=0;
	for(int i=1;i<=n;i++)
	{
		int temp = i;
		int temp1 = i;
		if(temp%10 == 0)
		{
			result += temp;
			continue;
		}
		while(temp>0)
		{
			int com = temp%10;
			if(com==2 || com==0 || com==1 || com==9)
			{
				result += temp1;
				break;
			}
			temp = temp/10;
		}
	}
	cout<<result<<endl;
	return 0;
}


