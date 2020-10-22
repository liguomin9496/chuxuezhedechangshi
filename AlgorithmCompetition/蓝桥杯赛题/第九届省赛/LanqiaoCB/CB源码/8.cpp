#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
 
int n,d,k;
const int maxn=1e5+5;
vector<int> thing[maxn];
 
bool judge(int id)
{
	int len=thing[id].size();
	if(len<k)
		return false;
	sort(thing[id].begin(),thing[id].end());//对每个Id的时刻进行排序 ，尺取法的使用必须结合排序，只有有序的区间，才能知道尺子的两端如何移动！ 
	int start=0;int end=0;
	int cnt=0;
	while(start<=end && end<len)//有序的区间也大大减少了盲目比较的次数，提高了运行速率。 
	{
		cnt++;
		if(cnt>=k)
		{
			if(thing[id][end]-thing[id][start]<d) //注意是小于(题中说是前闭后开区间 
				return true;
			else  //如果if语句不成立，那么你再去后移end，也是不符要求的，所以该后移start了 
			{
				cnt--;
				start++;
			} 
		}
		end++;
	} 
	return false;
}  
 
int main()
{
	cin>>n>>d>>k;
	for(int i=1;i<=n;i++)
	{
		int ts,id;
		cin>>ts>>id;
		thing[id].push_back(ts);
	}
 
     //取vector的长度，即有多少个id    
    for(int id=0;id<=n;id++){   
        if(judge(id))
            cout<<id<<endl;
	}
    return 0;
}
//这个题使用了尺取法，尺取法适用于在一定的区间里寻找 一定数量的满足某种条件的数的集合（该方法最好配合有序区间一起使用），确定两端的移动也是一个重要的点。
//本题最重要的是Vector数组的使用，vector是动态的数组容器，vectro数组中每一个vector元素也是一个动态的数组容器，对于一个vector数组来说，有.end()和.begin()方法来确定数组的首尾元素，同时有.size()方法

