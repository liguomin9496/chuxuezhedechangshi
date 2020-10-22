#include<iostream>
using namespace std;
int a[3]={0,0,0};
int res=0;
bool check(int k){
	if(a[0]+a[1]+a[2]==k)
		return true;
	return false;
}
bool checkNum(int num){
	while(num>0){
		int a = num%10;
		if(a==2 || a==4)
			return false;
		num /= 10;
	}
	return true;
}
void dfs(int step,int k){
	if(step>2){	
		if(check(k))
			res++;		
		return;	
	}
	for(int i=1;i<k;i++){
		if(checkNum(i))
		{
			if(step==1)	{				
				if(a[0]==i)
					continue;
			}
			if(step==2){
				if(a[0]==i || a[1]==i)
					continue;
			}					
			a[step]=i;				
			dfs(step+1,k);//在递归的时候不能使用++，进行变量的自加，++在递归里不能实现+1的功能。								
		}
		else
			continue;
	}
	return;
}
int main(){
	dfs(0,2019);
	cout<<res/6<<endl;
	return 0;	
}
