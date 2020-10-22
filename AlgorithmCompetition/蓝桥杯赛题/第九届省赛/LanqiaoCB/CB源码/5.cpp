#include <iostream>
#include<stdlib.h>
using namespace std;
int quick_select(int a[], int l, int r, int k) {
	int p = rand() % (r - l + 1) + l;
	int x = a[p];
	{int t = a[p]; a[p] = a[r]; a[r] = t;}
	int i = l, j = r;
	while(i < j) {
		while(i < j && a[i] < x) i++;
		if(i < j) {
			a[j] = a[i];
			j--;
		}
		while(i < j && a[j] > x) j--;
		if(i < j) {
			a[i] = a[j];
			i++;
		}
	}
	a[i] = x;
	p = i;
	if(i - l + 1 == k) return a[i];
	if(i - l + 1 < k) return quick_select(a,i+1,r,k-(i+1-l));
	else return quick_select(a, l, i - 1, k);
}
	
int main()
{
	int a[] = {1, 4, 2, 8, 5, 7, 23, 58, 16, 27, 55, 13, 26, 24, 12};
	printf("%d\n", quick_select(a, 0, 14, 5));
	return 0;
}
