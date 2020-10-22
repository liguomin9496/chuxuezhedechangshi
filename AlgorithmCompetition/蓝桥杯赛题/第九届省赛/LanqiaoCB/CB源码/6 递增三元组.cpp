#include<iostream>
#include<algorithm>
using namespace std;
const int MAX=100005;
int a[MAX],b[MAX],c[MAX];
int main()
{
	int n,sum=0;
	cin>>n;
	for(int i=0;i<n;i++)
		cin>>a[i];
	for(int j=0;j<n;j++)
		cin>>b[j];
	for(int k=0;k<n;k++)
		cin>>c[k];
	sort(a,a+n);
	sort(b,b+n);
	sort(c,c+n);
	for(int i=0;i<n;i++)	
		for(int j=0;j<n;j++)
			for(int k=0;k<n;k++)
			{				
				if(a[i]<b[j] && b[j]<c[k])
					sum++;			
			}
	cout<<sum<<endl;
	return 0;
}

