//int�ó���ʼ�մ��ھ�����ʧ���´μǵ��ڴ������г��֣�������ʽ�Ǽǵý�����ת��Ϊ�˷�������double�����ݣ�����
/*#include<iostream>
using namespace std;
int a[9];
int ans=0;
bool judge(int *a)//�ж��Ƿ���ʽ��Ϊ10
{
    double x=a[0]+a[1]*1.0/a[2]+(a[3]*100+a[4]*10+a[5])*1.0/(a[6]*100+a[7]*10+a[8]);
    if(x==10.0) return 1;
    return 0;
}
bool check(int num)//���a[num]�Ƿ����ظ�
{
    for(int i=num-1;i>=0;i--)
    {
        if(a[i]==a[num]) return 0;
    }
    return 1;
}
void dfs(int num)//�����������9����ȫ���У��ڽ�����������judge()���ж�
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
			repeat[i] = true;//�����ڹ�ϣ��--�ж��Ƿ��ù���������ף�����
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
									
