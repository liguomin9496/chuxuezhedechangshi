/*#include<iostream>//太大的数相乘还是太容易爆掉了，类似于第十届的数列求值，在题目没有限制性的提示下，还是要找规律
using namespace std;//这个例子还是只能通过不到70个数据！ 
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

//所有的0都是有2和5两个基础元素相乘而来的，所以可以将每一个数字都分解为2和5以及另外一个数相乘，最后2和5中较少的一个就是我们要求的结果
#include<iostream>
using namespace std;
int main()
{
    const int MAX = 100;
    int arr[MAX];
    int i;
    //把题目的100个数字直接复制粘贴 
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
            if( arr[i]%2==0 )    //可以分解出2 
            { 
                num2++;    
                arr[i]/=2;
            }     
            else if( arr[i]%5==0 )    //可以分解出5 
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


