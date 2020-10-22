//本例子给出计算机程序版本的十进制转二进制方法，并结合明码的转换，将明码表示的数字转换成汉字！
#include<iostream>
#include<cstring> 
#include<math.h>
using namespace std;
int arr[8];
void exchange(int value)    //转2进制函数
{
    int i=0;
    int va;
    va=fabs(value);
    while(va!=0)    //求出绝对值的二进制数
    {
        arr[i]=va%2;
        va/=2;//整除，小数取零
        i++;
    }
    if(value<0)    //负数求补码
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
{//这种不一定要完成全部数据就进行处理的思想值得自己学习和运用，在这个题可以大大简化成程序，节省存储空间    
    int a[32];   
    for(int e=0;e<=9;e++)    //十行数据
    {
        for(int i=0;i<=31;i++)    //一行32个数据
            cin>>a[i];       
        for(int i=0;i<=31;i++)
        {
            exchange(a[i]);
            for(int j=7;j>=0;j--)
                if(arr[j]==1)
                    cout<<arr[j];//倒入倒出，反反为正，恰好符合十进制转二进制
                else
                    cout<<" ";
            memset(arr,0,sizeof(arr)); 
            if(i%2==1)    //控制换行
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
