#include<iostream>
#include<cmath>
using namespace std;
int i=0;
int main()
{
	int Location(int,int,int abs[]);//abs�����¼��������кź�����λ�ã��� 
	int width,start,end,group;//group�趨Ϊ���������֮��ľ��룡�� 
	int slocation,location;//Location�趨Ϊ������֮��ľ��룬slocation�趨Ϊ����������ھ��룡�� 
	int abs[4] = {0,0,0,0};
	cin>>width;
	cin>>start;
	cin>>end;
	Location(start,width,abs);
	Location(end,width,abs);
	group = fabs(abs[2]-abs[0]);
	slocation = fabs(abs[1]-abs[3]);
	location = slocation+group;
	cout<<location<<endl;	
	return 0;
}
int Location(int input,int width,int abs[])
{
	int location,group;//�����location�趨Ϊÿһ���������λ�ã�group����Ϊ�к� 
	if(input%width == 0)//�������¥��ǡ���ܱ�������������¥���к�Ϊ���������Ľ��������+1��	
		group = input/width;
	else	
		group = input/width+1;
	if(group%2!=0)//�۲�¥�ŵ�����˳�����ǻᷢ��������¥�������У�ż����¥�������У��������ж�¥�ŵ���ż�� 
	{
		if(input%width == 0 )//����ע��¥���ܱ�������������ھ���λ�õ�ȷ�����赥�����㣡�� 
			location = width;
		else
			location = input%width;
	}
	else
	{
		if(input%width == 0 )
			location = 1;
		else			
			location = width-input%width+1;//���ｫ������������һ�£���Ϊע���ϸ����+1�����漰�����;����Լ�λ�õ�ȷ��ʱ��Ϊ��Ҫע��+1�����⣩���� 
	}
	abs[i] = group;	
	i++;
	abs[i] = location;	
	i++;
	return 0;
}
