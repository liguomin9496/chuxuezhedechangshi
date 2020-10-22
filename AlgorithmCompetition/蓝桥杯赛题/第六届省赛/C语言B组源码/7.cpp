//暴力解法
/*#include<iostream>
using namespace std;
int main()
{
	  int sum=0;
	 for(int i1=0;i1<=4;i1++)
		    for(int i2=0;i2<=4;i2++)
		    for(int i3=0;i3<=4;i3++)
		    for(int i4=0;i4<=4;i4++)
		    for(int i5=0;i5<=4;i5++)
		    for(int i6=0;i6<=4;i6++)
		    for(int i7=0;i7<=4;i7++)
		    for(int i8=0;i8<=4;i8++)
		    for(int i9=0;i9<=4;i9++)
		    for(int i10=0;i10<=4;i10++)
		    for(int i11=0;i11<=4;i11++)
		    for(int i12=0;i12<=4;i12++)
		    for(int i13=0;i13<=4;i13++){
		    	if((i1+i2+i3+i4+i5+i6+i7+i8+i9+i10+i11+i12+i13)==13)
		    		sum++;		    	
		    }
			cout<<sum;
			return 0;
}*/
#include<iostream>
using namespace std;
int count=0;
void dfs(int i,int k,int t){
	if(i>13)
	{//13堆抽完了 
		return;
	}
	if(t>=13)
	{//手上有13张牌了; 
      	if(t==13)		
			count++;
		return;
	}
	dfs(i+1,0,t+0);//下一堆拿0张 
	dfs(i+1,1,t+1);//下一堆拿1张 
	dfs(i+1,2,t+2);//下一堆拿2张 
	dfs(i+1,3,t+3);//下一堆拿3张 
	dfs(i+1,4,t+4);//下一堆拿4张 
} 
int main(){

	dfs(0,0,0);//代表抽第几堆抽牌，抽几张牌,当前手上牌的数目
	cout<<count<<endl;
	return 0; 
	
}
