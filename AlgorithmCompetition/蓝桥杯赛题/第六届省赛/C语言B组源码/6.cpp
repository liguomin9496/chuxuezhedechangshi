#include<iostream>
using namespace std;
int main()
{
	int sum;
	for(int i=1;i<=46;i++)
	{	
		for(int j=i+2;j<=48;j++)
		{			
			sum =1225 - (2*i+1+2*j+1);
			if((sum+j*(j+1)+i*(i+1))==2015)
				cout<<i<<endl;		
		}
	}			
	return 0;
}
/*using namespace std;
int main()
{
	int sum1,sum2;
	for(int i=1;i<=46;i++)
	{		
		for(int j=i+2;j<=48;j++)
		{
			sum1 = 1225-i-(i+1)-j-(j+1);
		    sum2 = 2015-(j*(j+1)+i*(i+1));
			if(sum1 == sum2)
				cout<<i<<endl;
		}
	

	}			
	return 0;
}*/