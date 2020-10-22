#include <stdio.h>
#include <string.h>
//最大公共子串的解决可以使用矩阵法解决，二维数组在平面上的排列形式就是一个矩阵 
#define N 256
int f(const char* s1, const char* s2)
{
	int a[N][N];
	int len1 = strlen(s1);
	int len2 = strlen(s2);
	int i,j;
	memset(a,0,sizeof(int)*N*N);
	int max = 0;
	for(i=1; i<=len1; i++){
		for(j=1; j<=len2; j++){
			if(s1[i-1]==s2[j-1]) {
				a[i][j] =  a[i-1][j-1]+1;  //填空
				if(a[i][j] > max) max = a[i][j];
			}
		}
	}
	
	return max;
}

int main()
{
	printf("%d\n", f("abcdkkk", "baabcdadabc"));
	return 0;
}

