//������ô����DFS�����һЩ�������������������ͼ�������۴��ĸ������ߵ�6����������ͬʱ�������������������DFSͬʱֻ��ѡһ�������ߵ��ס�
//����ֻ�����ҳ�5���������ʽ��Ȼ���ÿ����ʽ��DFS�������Ƿ���ͨ������
//����ʹ��һ�ַ�����һά����ģ���ά���鼰���ƶ�������� 
#include<iostream> 
using namespace std;
int Map[12]={1,2,3,4,6,7,8,9,11,12,13,14};//ע�������ά���������ȡ����ֻ��������ȡ��������һ���Ĺ���ȥģ�����ƶ�������� 
int vis[5],Conp[5];
int dir[4]={-5,+5,-1,+1};
int res=0;
void Dfs(int n){
	for(int i=0;i<4;i++){
		int temp = Conp[n]+dir[i];
		if(temp<1 || temp>14 || temp==10 || temp==5)
			continue;
		for(int j=0;j<5;j++){		
			if(vis[j]==0 && Conp[j]==temp){//����һ��DFS�ı��ε��뷨�������ж϶���Ƿ���ͨ���� 
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
