#include<iostream>
int len(int x){
	if(x<10) return 1;
	return len(x/10)+1;
}//��λ���ķ�������ӱ�����Գ�����return��ʹ�õݹ顣 
	
// ȡx�ĵ�kλ����
int f(int x, int k){
	if(len(x)-k==0) return x%10;
	return f(x/10,k);  //���
}
	
int main()
{
	int x = 23574;
	printf("%d\n", f(x,3));
	return 0;
}
