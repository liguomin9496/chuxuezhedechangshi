#include<iostream>
#include<algorithm>
#include<math.h>
#define l long 
using namespace std;
int main()
{
	int x,y;
	cin>>x>>y;
	l n = __max(abs(x),abs(y));//vc++6.0 __max函数的用发
	l res = 0,temp=0;
	if(x >= y)
	{
		res = n*8+n*(n-1)*8/2;
		temp = x+n+y+n;//因为每个层的正方形的结束点都相同是左下角那个点坐标为（-n,-n),
		//所以以这个点为相对点来计算距离，距离就是x--n+y--n->x+n+y+n!
		res -= temp;
	}
	else
	{
		temp = x+y+2*n;
		n--;
		res = n*8+n*(n-1)*8/2;
		res += temp;
	}
	cout<<res;
	return 0;
}
