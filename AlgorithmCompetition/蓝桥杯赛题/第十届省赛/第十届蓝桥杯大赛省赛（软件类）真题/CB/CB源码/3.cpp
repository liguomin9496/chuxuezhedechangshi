//从第一个例子我们可以看出这种类似斐波那契数列的值非常大，如果使用INT型的变量去运算容易溢出产生错误的结果（且没有错误提示）容易误将错误结果当做正确结果！
//在使用double型的变量进行运算时，容易溢出产生错误的结果，但是溢出时会有计算结果无穷大的提示，所以结合题目，他只要求后四位就可以使用取模运算来进行相应的简化
//只要后四位就取模10000，该方法既不会改变运算结果，又可以避免溢出无法求值的尴尬
#include<iostream>
using namespace std;
int main()
{
	int a1=1,a2=1,a3=1;
	int sum=0;
	for(int a=4;a<=20190324;a++)//20190324
	{
		sum = (a1+a2+a3)%10000;
		a1 = a2;
		a2 = a3;
		a3 = sum;
	}
	cout<<sum<<endl;
	return 0;
}
/*
#include<iostream>
using namespace std;
//题号：试题C: 数列求值
int A[20190400];
int main()
{
	A[1] = 1,A[2] = 1,A[3] = 1;
	
	for(int i = 4;i<=20190324; i++)
	{
		//由与题目的要求我们只需求得最后四位，所以模10000即可
		//不模的话很快就会溢出 
		A[i] = (A[i-1]+A[i-2]+A[i-3])%10000;
	}
	cout<<A[20190324]<<endl; 
	
	return 0;
}*/


