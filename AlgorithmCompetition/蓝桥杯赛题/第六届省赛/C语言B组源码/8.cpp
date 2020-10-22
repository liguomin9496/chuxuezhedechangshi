#include<iostream>
#include<cmath>
using namespace std;
int i=0;
int main()
{
	int Location(int,int,int abs[]);//abs数组记录两个点的行号和行内位置！！ 
	int width,start,end,group;//group设定为两个点的行之间的距离！！ 
	int slocation,location;//Location设定为两个点之间的距离，slocation设定为两个点的行内距离！！ 
	int abs[4] = {0,0,0,0};
	cin>>width;
	cin>>start;
	cin>>end;
	Location(start,width,abs);
	Location(end,width,abs);
	group = fabs(abs[2]-abs[0]);
	slocation = fabs(abs[1]-abs[3]);
	location = slocation+group;
	cout<<location<<endl;	
	return 0;
}
int Location(int input,int width,int abs[])
{
	int location,group;//这里的location设定为每一个点的行内位置，group设置为行号 
	if(input%width == 0)//若输入的楼号恰好能被宽度整除，则该楼的行号为两数整除的结果，否则+1！	
		group = input/width;
	else	
		group = input/width+1;
	if(group%2!=0)//观察楼号的排列顺序，我们会发现奇数号楼正序排列，偶数号楼逆序排列，所以先判断楼号的奇偶性 
	{
		if(input%width == 0 )//这里注意楼号能被宽度整除的行内具体位置的确定，需单独计算！！ 
			location = width;
		else
			location = input%width;
	}
	else
	{
		if(input%width == 0 )
			location = 1;
		else			
			location = width-input%width+1;//这里将正序排列逆序一下，尤为注意的细节是+1（在涉及减法和距离以及位置的确定时尤为需要注意+1的问题）！！ 
	}
	abs[i] = group;	
	i++;
	abs[i] = location;	
	i++;
	return 0;
}
