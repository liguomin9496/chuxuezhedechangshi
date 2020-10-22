#include<iostream>
#include<bits/stdc++.h>
using namespace std;
 
int n,d,k;
const int maxn=1e5+5;
vector<int> thing[maxn];
 
bool judge(int id)
{
	int len=thing[id].size();
	if(len<k)
		return false;
	sort(thing[id].begin(),thing[id].end());
	int start=0;int end=0;
	int cnt=0;
	while(start<=end && end<len)
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
    for(int id=0;id<=maxn;id++){
        if(judge(id))
            cout<<id<<endl;
    }
    return 0;
}
