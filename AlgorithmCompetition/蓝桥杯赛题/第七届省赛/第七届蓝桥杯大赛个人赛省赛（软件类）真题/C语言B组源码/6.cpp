#include<iostream>
#include<math.h>
using namespace std;
int Map[3][4]={0,1,1,1,1,1,1,1,1,1,1,0};
int vis[3][4];
int res=0;
void Dfs(int step,int x,int y){
	if(step==9){
		res++;
		return;
	}
	for(int i=0;i<3;i++){//这里本身就在遍历可以填数的其他位置，所以不用先找到其他位置，再逐一的遍历其上下左右，简化了许多 
		for(int j=0;j<4;j++){
			if(abs(j-y)<=1 && abs(i-x)<=1)//两条x轴的平行线和y轴平行线相交组成的正方形里面的方格都不能填数 
				continue; 
			else{				
					if(Map[i][j]==1 && vis[i][j]==0){
						vis[i][j]=1;															
						Dfs(step+1,i,j);
						vis[i][j]=0;					
					}					
				}
			}
		} 	
	}
int main(){
	for(int i=0;i<3;i++){
		for(int j=0;j<4;j++){
			if(Map[i][j]==1){
				vis[i][j]=1;
				Dfs(0,i,j);
				vis[i][j]=0;													
			}								
		}	
	}
	cout<<res<<endl;
} 
