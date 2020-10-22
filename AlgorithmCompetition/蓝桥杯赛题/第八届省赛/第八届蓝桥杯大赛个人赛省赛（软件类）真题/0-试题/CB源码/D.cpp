/*#include<iostream> 
using namespace std;
int book[10][10];
int dire[4][2]={-1,0,1,0,0,-1,0,1};//这种顺序是保证每次移动都是平行移动（不存在对角线那种移动） 
const int N=6;
int ans;
void dfs(int x,int y)
{
	if(x==0||y==N||x==N||y==0)//到达正方形的边缘 
	{
		ans++;
		return; 
	}//一次涂色完成，情况数+1	
	for(int i=0;i<4;i++)
	{
		int nx=x+dire[i][0];
		int ny=y+dire[i][1];//移动 
		if(nx<0||nx>N||ny<0||ny>N) continue;//跑到正方形外 
		if(book[nx][ny]==0)//如果没有涂色 
		{
			book[nx][ny]=1;//（nx,ny)与（N-nx,N-ny)为关于（3,3）的对称点 
			book[N-nx][N-ny]=1;//标记涂色部分 
			dfs(nx,ny);//以nx,ny为起点继续涂色（标记） 
			
			book[nx][ny]=0; 
			book[N-nx][N-ny]=0;//一次涂色完成后把标记的涂色部分清空 
		}
		
	}
}
int main()
{
	book[N/2][N/2]=1;
	dfs(N/2,N/2);
	cout<<ans/4<<endl; 
	return 0;
 } 
 //要想使分割出来的图形关于（3,3）对称，必须使其分割线 关于中心点对称，避免旋转对称必须/4！
 //为什么一定要使用DFS而不是BFS？？深入思考两种算法的不同和相同！！ */
 #include<iostream>
 using namespace std;
 int vis[7][7];
 int dir[4][2]={0,1,0,-1,-1,0,1,0};//上下左右
 const int N=6;
 int res=0;
 void dfs(int x,int y){
 	if(x==0 || x==N || y==0 || y==N){
 		res++;
 		return;
	 } 		
 	for(int i=0;i<4;i++){
 		int nx = x+dir[i][0];
 		int ny = y+dir[i][1];
 		if(nx<0 || nx>6 || ny<0 || ny>6)
 			continue;
 		if(vis[nx][ny]==0){
	 		vis[nx][ny]=1;
	 		vis[N-nx][N-ny]=1;
	 		dfs(nx,ny);
	 		vis[nx][ny]=0;
	 		vis[N-nx][N-ny]=0;
		}
	 }
 }
 int main()
{
	vis[N/2][N/2] = 1;	
	dfs(N/2,N/2);
	cout<<res/4<<endl; 
	return 0;
 } 
