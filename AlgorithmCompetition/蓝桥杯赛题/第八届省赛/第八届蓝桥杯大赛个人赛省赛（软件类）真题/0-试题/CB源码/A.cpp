#include<iostream>
using namespace std;
double cost[50][2];
double costCnt=0;
int main(){
	freopen("cost.txt","r",stdin);
	for(int i=0;i<50;i++){
		for(int j=0;j<2;j++){
			cin>>cost[i][j];
		}
	}
	for(int i=0;i<50;i++)		
		costCnt += cost[i][0]*cost[i][1];
	cout<<costCnt<<endl;
	return 0;	
}
 
