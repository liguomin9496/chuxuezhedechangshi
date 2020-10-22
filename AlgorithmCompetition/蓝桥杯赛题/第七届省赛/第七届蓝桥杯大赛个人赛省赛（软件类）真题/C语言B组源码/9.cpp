/*#include<iostream>
using namespace std;
int res=0;
int CheckRes(int n){
	if(n%2==0){
		if(res<n/2)
			return res;
		else
			return n/2;
	}
	else{
		if(res<n/2+1)
			return res;
		else
			return n/2+1;
	}
} 
int main(){
	int n,*num;
	cin>>n;
	num = new int[n];
	for(int i=0;i<n;i++)
		cin>>num[i];
	for(int i=0;i<n;i++){
		for(int j=i+1;j<n;j++){
			if(num[i]>num[j])
				res++;
			else
				i=j;
		}			
	}
	cout<<CheckRes(n)<<endl;
	return 0;
} */
#include<iostream>
using namespace std;
typedef long long ll;
int res=0;
int main()
{
    int n,*num;
    cin >> n;
    num = new int[n];
    for(int i = 1; i <= n; i++)
        cin >> num[i];    
    for(int i = 1;i <= n; i++)
    {
        while(i != num[i])///交换使当前的位置放相应的数
        {
            swap(num[i],num[num[i]]);
            res++;
        }
    }
    cout <<res<<endl;
    return 0;
}
/*#include <stdio.h>
#include <math.h>
 
int main()
{
	int arr[10010];		//记录第i个瓶子编号为多少
	int flag[10010];	//记录编号为i的瓶子在哪儿
	int ans = 0;
	int n,i;
	scanf("%d",&n);
 
	for(i = 1 ; i <= n ; i ++)
		scanf("%d",&arr[i]);
		
	for(i = 1 ; i <= n ; i ++ )
		flag[arr[i]] = i;
	
	for(i = 1 ; i <= n ; i ++)
	{
		if( i != arr[i] )
		{
			int x = arr[i];
			arr[i] ^= arr[flag[i]] ^= arr[i] ^= arr[flag[i]];
			flag[i] ^= flag[x] ^= flag[i] ^= flag[x];
			ans ++;
		}  
	}
	
	printf("%d\n",ans);
	return 0;
}*/
