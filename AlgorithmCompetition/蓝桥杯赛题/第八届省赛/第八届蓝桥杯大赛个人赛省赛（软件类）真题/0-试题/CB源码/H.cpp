#include<iostream> 
using namespace std;
int Gcd(int x,int y){
	if(x>y)
		return Gcd(y,x);
	if(x==0)
		return y;
	return Gcd(y%x,x);
}
int main(){
	cout<<Gcd(4,6)<<endl;
	return 0;	
}
