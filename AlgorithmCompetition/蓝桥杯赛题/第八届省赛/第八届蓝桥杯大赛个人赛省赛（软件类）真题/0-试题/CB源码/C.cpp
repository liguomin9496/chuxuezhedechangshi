#include<iostream>
using namespace std;
typedef long long LL;
const int n=30;
double number[n][n];
double Min(){
	double min = number[n-1][0];
	for(int i=1;i<n;i++)
		if(number[n-1][i]>=min)
			continue;
		else
			min = number[n-1][i];
	return min;
}
double Max(){
	double max = number[n-1][0];
	for(int i=1;i<n;i++)
		if(number[n-1][i]<=max)
			continue;
		else
			max = number[n-1][i];
	return max;
}
int main(){
	for(int i=0;i<n-1;i++){
		for(int j=0;j<=i;j++){
			cin>>number[i][j];			
		}	
	}
	for(int i=1;i<n;i++){
		for(int j=0;j<=i;j++){
			number[i][j] += number[i-1][j]/2;
			number[i][j+1] += number[i-1][j]/2;		
		}
	}
	double min = Min();
	double max = Max();
	cout<<min<<endl;
	cout<<max<<endl;
	LL result = max*(2086458231/min);	
	cout<<result<<endl;
	return 0;	
}

