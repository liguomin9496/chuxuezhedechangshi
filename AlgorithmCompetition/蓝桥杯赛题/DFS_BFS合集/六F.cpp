//本题的思维方式须有巧妙的转化，按常规想法，DFS解决分步问题，可以将拿牌分成13次，但是每一种数字的牌可以拿0~4次在递归里不太好解决
//但是主客体转换，要是将13种类型的牌看成13步，每一步拿走一种类型的牌就很好解决此问题 
#include<iostream>
using namespace std;
int res;
void dfs(int stack,int number){
	if(stack>13)	
		return;
	//自己做的时候，有缺点，没有考虑手上拿牌数可能超过 13
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
