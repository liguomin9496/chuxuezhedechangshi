#include<iostream>
#include<algorithm>
#include<math.h>
#define l long 
using namespace std;
int main()
{
	int x,y;
	cin>>x>>y;
	l n = __max(abs(x),abs(y));//vc++6.0 __max�������÷�
	l res = 0,temp=0;
	if(x >= y)
	{
		res = n*8+n*(n-1)*8/2;
		temp = x+n+y+n;//��Ϊÿ����������εĽ����㶼��ͬ�����½��Ǹ�������Ϊ��-n,-n),
		//�����������Ϊ��Ե���������룬�������x--n+y--n->x+n+y+n!
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
