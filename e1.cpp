#include <iostream>
#include <string>
using namespace std;
template <class T>
class TArray_max
{ 
public:      
	TArray_max(int n)	//构造函数
	{
		num=n;				//保存元素个数
		array=new T[num];	//动态分配数组空间
		if(array==NULL)		//检查分配成功否？
		{
			cout<<"分配失败"<<endl;
			exit(1);
		}
	}
	~TArray_max()		//析构函数
	{
		delete[] array;		//释放空间
	}
	void SetValue();	//为数组输入数据
    void GetMax();	//求最大元素   
    void ShowMax();	//显示最大元素
private:
	T *array;	//数组空间首地址
	int num;	//元素个数
	T max;		//最大元素
};
template <class T>
void TArray_max<T>::SetValue( )
{
	cout<<"请输入"<<num<<"个数据"<<endl;
    for (int i=0;i<num;i++)
		cin>>array[i];  
}
template <class T>
void TArray_max<T>::GetMax( )      
{
    max=array[0];
    for(int i=1;i<num;i++)
		if(array[i]>max) 
			max=array[i];
}
template <class T>
void TArray_max<T>::ShowMax( )    
{
	cout<<"max="<<max<<endl;
}

int main( )
{ 
	int n;
	cout<<"请输入数据个数：";
	cin>>n;

	cout<<"整数序列："<<endl;
	TArray_max<int> a(n);	//建立对象a   
	a.SetValue();		//输入数据
	a.GetMax();		//计算最大元素
	a.ShowMax();		//显示最大元素

	cout<<"字符串序列："<<endl;
	TArray_max<string> b(n);//建立对象b   
	b.SetValue();		//输入数据
	b.GetMax();		//计算最大元素
	b.ShowMax();		//显示最大元素
	return 0;
}