#include<iostream>
#include<iomanip>
using namespace std;
int main()
{
	int i,j,k,m=0,n;
	const int l=100;
	int a[l][l];
    cout<<"please input n!"<<endl;
	cin>>n;
	if(n%2==0)
		k=n/2;
	else 
		k=n/2+1;
	for(j=0;j<k;j++)
	{
		for(i=j;i<n-j;i++)
		{
			m++;
			a[j][i]=m;
		}
		for(i=j+1;i<n-j-1;i++)
		{
			m++;
			a[i][n-j-1]=m;
		}        
		for(i=j;i<n-j;i++)
		{
         if(j==k-1)
		   break;
			m++;
			a[n-j-1][n-i-1]=m;
		}	
		for(i=n-j-2;i>=j+1;i--)
		{
			m++;
			a[i][j]=m;
		}
	}
	for(i=0;i<n;i++)
	{
		for(j=0;j<n;j++)
			cout<<setw(8)<<a[i][j];
		cout<<endl;
	}
	return 0;
}
