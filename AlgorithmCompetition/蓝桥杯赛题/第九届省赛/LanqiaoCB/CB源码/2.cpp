//�����Ӹ������������汾��ʮ����ת�����Ʒ���������������ת�����������ʾ������ת���ɺ��֣�
#include<iostream>
#include<cstring> 
#include<math.h>
using namespace std;
int arr[8];
void exchange(int value)    //ת2���ƺ���
{
    int i=0;
    int va;
    va=fabs(value);
    while(va!=0)    //�������ֵ�Ķ�������
    {
        arr[i]=va%2;
        va/=2;//������С��ȡ��
        i++;
    }
    if(value<0)    //��������
    {
        for(i=0;i<=7;i++)
        {
            if( arr[i]==1)
            {                
                for(int j=i+1;j<=7;j++)
                {
                    if( arr[j]==0 )
                        arr[j]=1;
                    else
                        arr[j]=0;
                }
                break;
            }
        }
    }
}

int main()
{//���ֲ�һ��Ҫ���ȫ�����ݾͽ��д����˼��ֵ���Լ�ѧϰ�����ã����������Դ��򻯳ɳ��򣬽�ʡ�洢�ռ�    
    int a[32];   
    for(int e=0;e<=9;e++)    //ʮ������
    {
        for(int i=0;i<=31;i++)    //һ��32������
            cin>>a[i];       
        for(int i=0;i<=31;i++)
        {
            exchange(a[i]);
            for(int j=7;j>=0;j--)
                if(arr[j]==1)
                    cout<<arr[j];//���뵹��������Ϊ����ǡ�÷���ʮ����ת������
                else
                    cout<<" ";
            memset(arr,0,sizeof(arr)); 
            if(i%2==1)    //���ƻ���
                cout<<endl;
        }
    }
    return 0;
}
/*#include<iostream>
using namespace std;
int main()
{
	int a,b,c;
	a = 1;
	b = 2;
	cout<<a/b;
	return 0;
}*/
