//int用除法始终存在精度损失，下次记得在此类题中出现，除法等式是记得将除法转换为乘法或者用double型数据！！！
/*#include<iostream>
using namespace std;
int a[9];
int ans=0;
bool judge(int *a)//判断是否算式和为10
{
    double x=a[0]+a[1]*1.0/a[2]+(a[3]*100+a[4]*10+a[5])*1.0/(a[6]*100+a[7]*10+a[8]);
    if(x==10.0) return 1;
    return 0;
}
bool check(int num)//检测a[num]是否有重复
{
    for(int i=num-1;i>=0;i--)
    {
        if(a[i]==a[num]) return 0;
    }
    return 1;
}
void dfs(int num)//就是最基本的9个数全排列，在结束条件里用judge()做判断
{
    if(num>8)
    {
        if(judge(a))
        ans++;
        return;
    }
    for(int i=1;i<10;i++)
    {
        a[num]=i;
        if(check(num))
        {
            dfs(num+1);
        }
    }
}
int main()
{
    dfs(0);
    cout<<ans;
    return 0;
}*/

#include<iostream>
using namespace std;
int ress=0;
bool check(int a[])
{
	int def,ghi;
	def = a[3]*100+a[4]*10+a[5];
	ghi = a[6]*100+a[7]*10+a[8];	
	if((10-a[0])*ghi*a[2]==a[1]*ghi+def*a[2])
		return true;
	return false;
}
void function(int step,int num[],bool repeat[])
{
	if(step > 8)
	{
		if(check(num))		
			ress++;		
		return;
	}
	for(int i=1;i<=9;i++)
	{
		if(repeat[i] == false)
		{
			repeat[i] = true;//类似于哈希表--判断是否被用过，精妙绝伦！！！
			num[step] = i;
			function(step+1,num,repeat);
			repeat[i] = false;
		}
	}
	return;
}

int main()
{	
	int step=0;
	int num[10];
	bool repeat[10]={false,false,false,false,false,false,false,false,false,false};
	function(step,num,repeat);
	cout<<ress<<endl;
	return 0;
}
									
