//ˤһ���ֻ�����¥���Ϊ�����֣������¥����Ҫ�ֻ��� - 1 ��ȷ���������¥�㲿���ֻ�������ȷ�������ǲ�֪�������ĸ�¥�㽫��ǰ¥���Ϊ�����֣��������Ǳ��� k ��ȷ����
//����һ����Ϊ�ֻ�������¥����
/*#include<iostream>
using namespace std;
#define Max(a,b) (a>b?a:b)//���ַ����ǣ�
#define Min(a,b) (a<b?a:b)
int dp[1005][50];
int main()
{
    int n,m;
    cin>>n>>m;
    for (int i=1;i<=n;i++)
        dp[i][1]=i;//һ���ֻ�Ҫ��ȷ��ˤ���ٴξ�ֻ��һ��һ���ˤ��ȥ
    for (int cnt=2;cnt<=m;cnt++)
    {
        for (int ind=1;ind<=n;ind++)
        {
            dp[ind][cnt]=1+dp[ind-1][cnt];
            for (int k=2;k<ind;k++)
                dp[ind][cnt]=Min(dp[ind][cnt],1+Max(dp[k-1][cnt-1],dp[ind-k][cnt]));//��һ������ֵһ��������һ�����Сֵ+1
			//���Ų��ԣ����ȡ��Сֵ�������ÿ��ˤ�ֻ���ȡ���ֵ
        }
    }
    cout<<dp[n][m]<<endl;
    return 0;
}*/
//����������Ϊ�ֻ�������ˤ�ֻ���
/*�����֪ˤ�ֻ����� i ���ֻ����� j ��dp[ i ][ j ] Ϊ���ȷ��¥�����ֵ����ǰ��ȷ�������¥�����ͻ���ˤ�ֻ����� i - 1 ��
�ֻ����� j �� j - 1 �µĿ�ȷ��¥�������ֵ֮�ͣ�Ҳ��Ҫ����ÿ��ˤ�ֻ�����ȷ����ˤ¥��,ÿˤһ�����ٿ���ȷ��һ�㣬�����Ƴ���

dp[ i ][ j ] = dp[ i - 1 ][ j ] + dp[ i - 1 ][ j - 1 ] + 1

ȷ��Ŀ��¥�� n �����Ҫˤ���ٴ��ֻ��أ��ǿ϶����ֻ�ֻ��һ����ʱ��
�����Ҫ n �β���ȷ��Ŀ��¥�㡣�����趨ˤ�ֻ����� i �� 1 �� n ������
���㵱ǰ�������ֻ���Ϊָ��ֵ m ʱ�� dp[ i ][ m ] �Ƿ���ڵ���Ŀ��¥��n�������������С��ˤ�ֻ�������������ɡ�*/
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