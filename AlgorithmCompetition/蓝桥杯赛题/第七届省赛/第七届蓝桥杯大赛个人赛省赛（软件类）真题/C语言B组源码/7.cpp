//这个题用纯粹的DFS会存在一些遍历不到的情况，例如图三，不论从哪个方向走到6，都会面临同时走两个方向的困境，而DFS同时只能选一个方向走到底。
//此题只能先找出5个的组合形式，然后对每个形式用DFS测试其是否联通！！！
//这里使用一种方法用一维数组模拟二维数组及其移动情况！！ 
#include<iostream> 
using namespace std;
int Map[12]={1,2,3,4,6,7,8,9,11,12,13,14};//注意这里二维数组的特殊取数，只有这样的取数才能用一定的规律去模拟其移动情况！！ 
int vis[5],Conp[5];
int dir[4]={-5,+5,-1,+1};
int res=0;
void Dfs(int n){
	for(int i=0;i<4;i++){
		int temp = Conp[n]+dir[i];
		if(temp<1 || temp>14 || temp==10 || temp==5)
			continue;
		for(int j=0;j<5;j++){		
			if(vis[j]==0 && Conp[j]==temp){//这是一种DFS的变形的想法，用来判断多点是否连通！！ 
				vis[j]=1;
				Dfs(j);				
			}
		}
	}	
}
int main(){	
	for(int a=0;a<12;a++)
		for(int b=a+1;b<12;b++)
			for(int c=b+1;c<12;c++)
				for(int d=c+1;d<12;d++)
					for(int e=d+1;e<12;e++){
						Conp[0]=Map[a];
						Conp[1]=Map[b];
						Conp[2]=Map[c];
						Conp[3]=Map[d];
						Conp[4]=Map[e];
						for(int i=0;i<5;i++)
							vis[i]=0;
						vis[0]=1;
						Dfs(0);
						int flag=1;
						for(int i=0;i<5;i++)
							flag*=vis[i];
						if(flag==1)
							res++;						
					}
		cout<<res<<endl;
		return 0;
}
