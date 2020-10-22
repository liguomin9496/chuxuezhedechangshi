#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
 
int n,d,k;
const int maxn=1e5+5;
vector<int> thing[maxn];
 
bool judge(int id)
{
	int len=thing[id].size();
	if(len<k)
		return false;
	sort(thing[id].begin(),thing[id].end());//��ÿ��Id��ʱ�̽������� ����ȡ����ʹ�ñ���������ֻ����������䣬����֪�����ӵ���������ƶ��� 
	int start=0;int end=0;
	int cnt=0;
	while(start<=end && end<len)//���������Ҳ��������äĿ�ȽϵĴ�����������������ʡ� 
	{
		cnt++;
		if(cnt>=k)
		{
			if(thing[id][end]-thing[id][start]<d) //ע����С��(����˵��ǰ�պ����� 
				return true;
			else  //���if��䲻��������ô����ȥ����end��Ҳ�ǲ���Ҫ��ģ����Ըú���start�� 
			{
				cnt--;
				start++;
			} 
		}
		end++;
	} 
	return false;
}  
 
int main()
{
	cin>>n>>d>>k;
	for(int i=1;i<=n;i++)
	{
		int ts,id;
		cin>>ts>>id;
		thing[id].push_back(ts);
	}
 
     //ȡvector�ĳ��ȣ����ж��ٸ�id    
    for(int id=0;id<=n;id++){   
        if(judge(id))
            cout<<id<<endl;
	}
    return 0;
}
//�����ʹ���˳�ȡ������ȡ����������һ����������Ѱ�� һ������������ĳ�����������ļ��ϣ��÷�����������������һ��ʹ�ã���ȷ�����˵��ƶ�Ҳ��һ����Ҫ�ĵ㡣
//��������Ҫ����Vector�����ʹ�ã�vector�Ƕ�̬������������vectro������ÿһ��vectorԪ��Ҳ��һ����̬����������������һ��vector������˵����.end()��.begin()������ȷ���������βԪ�أ�ͬʱ��.size()����

