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
	for(int i=0;i<3;i++){//���ﱾ����ڱ�����������������λ�ã����Բ������ҵ�����λ�ã�����һ�ı������������ң�������� 
		for(int j=0;j<4;j++){
			if(abs(j-y)<=1 && abs(i-x)<=1)//����x���ƽ���ߺ�y��ƽ�����ཻ��ɵ�����������ķ��񶼲������� 
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
