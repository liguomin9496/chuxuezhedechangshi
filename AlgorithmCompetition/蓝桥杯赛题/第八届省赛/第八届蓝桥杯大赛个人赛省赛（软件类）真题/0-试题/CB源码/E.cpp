#include<iostream>
int len(int x){
	if(x<10) return 1;
	return len(x/10)+1;
}//求位数的方法很新颖，可以尝试在return中使用递归。 
	
// 取x的第k位数字
int f(int x, int k){
	if(len(x)-k==0) return x%10;
	return f(x/10,k);  //填空
}
	
int main()
{
	int x = 23574;
	printf("%d\n", f(x,3));
	return 0;
}
