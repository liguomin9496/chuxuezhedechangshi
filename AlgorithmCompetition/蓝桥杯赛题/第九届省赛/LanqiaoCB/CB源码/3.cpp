/*#include<iostream>//̫�������˻���̫���ױ����ˣ������ڵ�ʮ���������ֵ������Ŀû�������Ե���ʾ�£�����Ҫ�ҹ���
using namespace std;//������ӻ���ֻ��ͨ������70�����ݣ� 
int num[100];
int main()
{
	freopen("number.txt","r",stdin);
	for(int i=0;i<100;i++)
		cin>>num[i];
	long int sum=1;
	int res=0;
	for(int i=0;i<100;i++)
	{
		while(num[i]%10 == 0)
		{
			num[i] /= 10;
			res++;
		}
		sum =(sum * num[i])%10000;
		
		while(sum%10 == 0)
		{
			sum /= 10;
			res++;
		}
		cout<<i<<endl;
	}
	cout<<res<<endl;
	return 0;
}*/

//���е�0������2��5��������Ԫ����˶����ģ����Կ��Խ�ÿһ�����ֶ��ֽ�Ϊ2��5�Լ�����һ������ˣ����2��5�н��ٵ�һ����������Ҫ��Ľ��
#include<iostream>
using namespace std;
int main()
{
    const int MAX = 100;
    int arr[MAX];
    int i;
    //����Ŀ��100������ֱ�Ӹ���ճ�� 
    for(i=0;i<MAX;i++)
	{  
		cin>>arr[i];
        if(arr[i] == 0)
		{    
			cout<<1;
            return 0;
        }
    }        
    int num2=0,num5=0;
    for(i=0;i<MAX;i++)
    {
        while(1)
        { 
            if( arr[i]%2==0 )    //���Էֽ��2 
            { 
                num2++;    
                arr[i]/=2;
            }     
            else if( arr[i]%5==0 )    //���Էֽ��5 
            {
                 num5++;
                 arr[i]/=5;
             }
             else
                  break;
        } 
    }    
    cout<<((num2<num5)?num2:num5)<<endl;
    return 0;
}


