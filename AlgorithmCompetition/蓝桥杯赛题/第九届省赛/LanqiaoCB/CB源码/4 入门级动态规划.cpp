//摔一部手机会让楼层分为两部分，下面的楼层需要手机数 - 1 后确定，上面的楼层部分手机数不变确定，我们不知道该在哪个楼层将当前楼层分为两部分，所以我们遍历 k 来确定。
//方法一变量为手机数量和楼层数
/*#include<iostream>
using namespace std;
#define Max(a,b) (a>b?a:b)//这种方法是？
#define Min(a,b) (a<b?a:b)
int dp[1005][50];
int main()
{
    int n,m;
    cin>>n>>m;
    for (int i=1;i<=n;i++)
        dp[i][1]=i;//一个手机要想确定摔多少次就只能一层一层的摔上去
    for (int cnt=2;cnt<=m;cnt++)
    {
        for (int ind=1;ind<=n;ind++)
        {
            dp[ind][cnt]=1+dp[ind-1][cnt];
            for (int k=2;k<ind;k++)
                dp[ind][cnt]=Min(dp[ind][cnt],1+Max(dp[k-1][cnt-1],dp[ind-k][cnt]));//这一层的最大值一定等于上一层的最小值+1
			//最优策略，结果取最小值，最坏运气每层摔手机数取最大值
        }
    }
    cout<<dp[n][m]<<endl;
    return 0;
}*/
//方法二变量为手机数量和摔手机数
/*这次已知摔手机次数 i 和手机数量 j ，dp[ i ][ j ] 为其可确定楼层最大值。当前可确定的最多楼层数就会是摔手机次数 i - 1 ，
手机数量 j 和 j - 1 下的可确定楼层数最大值之和，也不要忘了每次摔手机都会确定所摔楼层,每摔一部至少可以确定一层，所以推出：

dp[ i ][ j ] = dp[ i - 1 ][ j ] + dp[ i - 1 ][ j - 1 ] + 1

确定目标楼层 n 最多需要摔多少次手机呢？那肯定是手机只有一部的时候，
最多需要 n 次才能确定目标楼层。我们设定摔手机次数 i 从 1 到 n 遍历，
计算当前次数下手机数为指定值 m 时的 dp[ i ][ m ] 是否大于等于目标楼层n，这样计算出最小的摔手机次数后输出即可。*/
#include <iostream>
using namespace std;
int dp[1005][50];
int main()
{
    int n, m;
    cin>>n>>m;
    for (int i = 1; i <= n; ++i)
    {
        for (int j = 1; j <= m; ++j)
            dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1] + 1;
        if (dp[i][m] >= n)
        {
            cout<<i<<endl;
            break;
        }
    }
    return 0;
}
//https://blog.csdn.net/belous_zxy/article/details/80543276