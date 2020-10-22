#include<iostream>
#include<queue>
#include<string> 
int dir[4][2]={1,0,0,-1,0,1,-1,0};
char Map[30][50];
int vis[30][50];//int型数组初始化为0!!! 
char dic[4]={'D','L','R','U'};
using namespace std;
struct node{
	int x;
	int y;
	int step;
	string path;
	node(int xx,int yy,int ss,string pp){
		x = xx;
		y = yy;
		step = ss;
		path = pp;		
	}
};
bool CheckPos(int x,int y){
	if(x>=0 && x<30)
		if(y>=0 && y<50)
			if(vis[x][y]==0 && Map[x][y]=='0')
				return true;
	return false;
}
queue<node>q;
void Bfs(int x,int y){
	q.push(node(x, y,0,""));
	vis[x][y]=1;
	while(!q.empty())
	{	
		node now = q.front();
		if(now.x==29 && now.y==49)
		{
			cout<<now.path<<endl;
			cout<<now.step<<endl;			
			break;
		}
		q.pop();
		for(int i=0;i<4;i++){
			int nx = now.x+dir[i][0];
			int ny = now.y+dir[i][1];		
			if(CheckPos(nx,ny)){				
				vis[nx][ny]=1;
				q.push(node(nx,ny,now.step+1,now.path+dic[i]));				
			}
				
		}
	}
	
}
int main(){
	freopen("maze.txt","r",stdin);	
	for(int i=0;i<30;i++){
		for(int j=0;j<50;j++)
			cin>>Map[i][j];
	}
	Bfs(0,0);
	return 0;	
}
