/*#include <iostream>
using namespace std;
#define N 1000
 
int Map[N][N], visit[N][N];//用Visit数组来确定是否是一个岛屿，以一个陆地开始访问其上下左右，能访问到的就是Visit！ 
//visit数组可以确定一个岛屿的边界！ 
// 广度优先遍历周围的陆地
// 若有其中一块陆地四周皆为陆地则不会被淹没
// 反之则会被淹没 return 0
int bfs( int i, int j)
{
	int flag = 0;  //该陆地四周是否全为陆地
	if( Map[i+1][j] && Map[i][j+1] && Map[i-1][j] && Map[i][j-1]) flag=1;//该陆地四周均为是陆地 
	if( Map[i+1][j] && visit[i+1][j]==0) {
		visit[i+1][j]=1;
		flag+=bfs(i+1,j);
	}
	if( Map[i][j+1] && visit[i][j+1]==0) {
		visit[i][j+1]=1;
		flag+=bfs(i,j+1);
	}
	if( Map[i-1][j] && visit[i-1][j]==0){
		 visit[i-1][j]=1;
		 flag+=bfs(i-1,j);
	}
	if( Map[i][j-1] && visit[i][j-1]==0) {
		visit[i][j-1]=1;
		flag+=bfs(i,j-1);
	}	
	return flag>0?1:0;
}
 
//求解给定地图上会被淹没的小岛数
int numofIslands( int n)
{
	int num = 0; //记录会被淹没的小岛数
	for( int i=0; i<n; i++) {
		for( int j=0; j<n; j++) {
			if( Map[i][j] && visit[i][j]==0) {
				num += 1-bfs( i, j);//一次DFS访问出一个岛屿的边界，访问到0就回溯一次				
			}
		}
	}
	return num;
}
 //学习这种C++的字符的输入输出 
int main()
{
	int n=0;
	cin>>n;	
	for( int i=0; i<n; i++) {
		getchar();   // get'\n',换行 
		for( int j=0; j<n; j++) {
			if( getchar()=='.')
				Map[i][j]=0;//让海水为0 
			else
				Map[i][j]=1;
		}
	}	
	cout<<numofIslands(n);
	return 0;
}*/
/*
#include<iostream>
using namespace std;
const int N=1000;
int Map[N][N];
int visit[N][N];
int res=0;
int bfs(int i,int j){
	int flag = 0;
	if(Map[i][j-1]&&Map[i][j+1]&&Map[i-1][j]&&Map[i+1][j])
		flag = 1;
	if(Map[i][j-1] && visit[i][j-1]==0){
		visit[i][j-1]=1;
		flag += bfs(i,j-1);
	}
	if(Map[i][j+1] && visit[i][j+1]==0){
		visit[i][j+1]=1;
		flag += bfs(i,j+1);
	}
	if(Map[i-1][j] && visit[i-1][j]==0){
		visit[i-1][j]=1;
		flag += bfs(i-1,j);
	}
	if(Map[i+1][j] && visit[i+1][j]==0){
		visit[i+1][j]=1;
		flag += bfs(i+1,j);
	}
	return flag>0?1:0;
} 
void NumOfIsland(int n){
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			if(Map[i][j]&&visit[i][j]==0)
				res += 1-bfs(i,j);
		}
	}
}
int main(){
	int n;
	cin>>n;
	for(int i=0;i<n;i++){
		getchar();
		for(int j=0;j<n;j++){
			if(getchar() == '.')
				Map[i][j]=0;
			else
			 	Map[i][j]=1;
		}
	}
	NumOfIsland(n);
	cout<<res<<endl;
	cout<<Map[0][0]<<endl;
	return 0;
}*/
#include<iostream>
#include<queue>
using namespace std;
#define N 1000
int visit[N][N],Map[N][N];
int dir[4][2]={0,-1,0,1,-1,0,1,0};
int res=0;
struct node{
	int x;
	int y;
	node(int xx,int yy){
		x = xx;
		y = yy;
	}
};
queue<node>q;
int Bfs(int x,int y){
	q.push(node(x,y));	
	int flag = 0;
	while(!q.empty()){
		node now = q.front();
		q.pop();
		if(Map[now.x][now.y-1]&&Map[now.x][now.y+1]&&Map[now.x-1][now.y]&&Map[now.x+1][now.y])
			flag++;		
		for(int i=0;i<4;i++){		
			int nx = now.x+dir[i][0];
			int ny = now.y+dir[i][1];
			if(Map[nx][ny]&&visit[nx][ny]==0){
				q.push(node(nx,ny));
				visit[nx][ny]=1;											
			} 
		}		
	}
	return flag>0?1:0;		
}
int NumOfIsland(int n){
	for(int i=1;i<n;i++)
		for(int j=1;j<n;j++){
			if(Map[i][j]&&visit[i][j]==0){
				res += 1-Bfs(i,j);//
				cout<<i<<"  "<<j<<res<<endl;
			}
		}
}
int main(){
	int n;
	cin>>n;
	for(int i=0;i<n;i++){
		getchar();
		for(int j=0;j<n;j++){
			if(getchar() == '#')
				Map[i][j]=1;
			else
			 	Map[i][j]=0;
		}
	}
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++)
			cout<<Map[i][j]<<" ";
		cout<<endl;
	}
	NumOfIsland(n);
	cout<<res<<endl;
	return 0;
} 
