/*#include<iostream> 
using namespace std;
int book[10][10];
int dire[4][2]={-1,0,1,0,0,-1,0,1};//����˳���Ǳ�֤ÿ���ƶ�����ƽ���ƶ��������ڶԽ��������ƶ��� 
const int N=6;
int ans;
void dfs(int x,int y)
{
	if(x==0||y==N||x==N||y==0)//���������εı�Ե 
	{
		ans++;
		return; 
	}//һ��Ϳɫ��ɣ������+1	
	for(int i=0;i<4;i++)
	{
		int nx=x+dire[i][0];
		int ny=y+dire[i][1];//�ƶ� 
		if(nx<0||nx>N||ny<0||ny>N) continue;//�ܵ��������� 
		if(book[nx][ny]==0)//���û��Ϳɫ 
		{
			book[nx][ny]=1;//��nx,ny)�루N-nx,N-ny)Ϊ���ڣ�3,3���ĶԳƵ� 
			book[N-nx][N-ny]=1;//���Ϳɫ���� 
			dfs(nx,ny);//��nx,nyΪ������Ϳɫ����ǣ� 
			
			book[nx][ny]=0; 
			book[N-nx][N-ny]=0;//һ��Ϳɫ��ɺ�ѱ�ǵ�Ϳɫ������� 
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
 //Ҫ��ʹ�ָ������ͼ�ι��ڣ�3,3���Գƣ�����ʹ��ָ��� �������ĵ�Գƣ�������ת�ԳƱ���/4��
 //Ϊʲôһ��Ҫʹ��DFS������BFS��������˼�������㷨�Ĳ�ͬ����ͬ���� */
 #include<iostream>
 using namespace std;
 int vis[7][7];
 int dir[4][2]={0,1,0,-1,-1,0,1,0};//��������
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
