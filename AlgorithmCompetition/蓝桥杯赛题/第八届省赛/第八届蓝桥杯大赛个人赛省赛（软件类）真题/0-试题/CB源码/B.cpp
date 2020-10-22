/*#include<iostream> 
#include<algorithm>
#include<vector>
using namespace std;
int maxn=10000;
int cnt=1;
vector<int> primer;
bool isPrimer(int number){
	for(int i=2;i<number;i++){
		if(number%i==0){
			return false;
			break;
		}		
	}
	return true;
}
bool Find(int number,int len){
	for(int i=0;i<len;i++)
		if(i == primer[i])
			return true;			
	return false;
}
int main(){
	for(int i=2;i<maxn;i++){
		if(isPrimer(i))
			primer.push_back(i);
		else
			continue;			
	}
	sort(primer.begin(),primer.end());
	int length = primer.size();	
	for(int i=0;i<length;i++){
		int mind = 1;
		cnt=1;
		int n=primer[i];
		while(mind<=1000)
		{	
			for(int j=1;j<10;j++){			
				int temp = n+j*mind;
				if(Find(temp,length)){
					cnt++;
					continue;
				}
				else
					mind++;
				if(cnt == 10){
					cout<<mind<<endl;
					break;
				}
			}
		}
	}
	
}*/
#include<iostream>
using namespace std;
bool isPrimer(int number){
	for(int i=2;i<number;i++){
		if(number%i==0)
			return false;		
	}
	return true;
}
int main(){	
	for(int i=2;i<10000;i++){
		if(isPrimer(i)){			
			for(int d=2;d<1000;d++){
				int count=1;
				for(int j=1;j<10;j++){
					int temp = i+d*j;
					if(isPrimer(temp))
						count++;					
					if(count == 10){						
						cout<<d<<endl;
						return 0;//这儿推荐用return(大返) 
					}
				}
			}
		}
	}
}
