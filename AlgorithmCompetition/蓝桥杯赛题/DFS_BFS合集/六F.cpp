//�����˼ά��ʽ���������ת�����������뷨��DFS����ֲ����⣬���Խ����Ʒֳ�13�Σ�����ÿһ�����ֵ��ƿ�����0~4���ڵݹ��ﲻ̫�ý��
//����������ת����Ҫ�ǽ�13�����͵��ƿ���13����ÿһ������һ�����͵��ƾͺܺý�������� 
#include<iostream>
using namespace std;
int res;
void dfs(int stack,int number){
	if(stack>13)	
		return;
	//�Լ�����ʱ����ȱ�㣬û�п����������������ܳ��� 13
	if(number >= 13){
		if(number==13)
			res++;
		return;
	}	
	dfs(stack+1,number+0);
	dfs(stack+1,number+1);
	dfs(stack+1,number+2);
	dfs(stack+1,number+3);
	dfs(stack+1,number+4);
	return;
}
int main(){
	dfs(0,0);
	cout<<res<<endl;
}
