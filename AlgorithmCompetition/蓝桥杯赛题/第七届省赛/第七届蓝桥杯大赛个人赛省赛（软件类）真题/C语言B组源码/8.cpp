//773535,这个测试用例在1（自写） 2（借鉴）两个demo中运行表现出了截然不同的运行效果，而借鉴的优化之处在于避免了很多不必要的循环次数，所以在编程当中
//一定不要轻视循环变量的作用，一定要在可能的情况下，尽量减小循环的开销！！！ 而且自己写的demo在运行到773535以及之后时，由于未优化循环变量，造成K的平方值
//过于巨大，溢出了int型的取值范围，然后在奇妙的操作下造成了773535之后的结果全部错误 不能AC，虽然可以用ll来解决一定的问题，但是最根本的还是
//养成对程序中的各种变量尽可能优化的习惯，以减少可避免的错误，和节约时间以及空间！！ 
/*#include<iostream>
#include<cmath>
using namespace std;
int main(){
	int num;
	cin>>num;
	for(int i=0;i<num;i++){		
		for(int j=i;j<num;j++){		
			for(int k=j;k<num;k++){
			 if(int(pow(int(pow(num-i*i-j*j-k*k, 0.5)), 2)) == (num-i*i-j*j-k*k)) {
			 		cout<<k*k<<endl;
			 		cout<<k<<endl;
			 		cout<<(int(pow(int(pow(num-i*i-j*j-k*k, 0.5)), 2)))<<endl;
                    cout << i << ' ' << j << ' ' << k << ' ' << pow(num-i*i-j*j-k*k, 0.5);
                    return 0;
                }
				
			}
		}
	} 
	cout<<"无效数据！"<<endl; 
}*/

#include <iostream>
#include <cmath>
using namespace std;

int main()
{
    int n;
    cin >> n;
    for(int i = 0; i*i < n; ++i) {
        for(int j = i; j*j + i*i < n; ++j) {
            for(int k = j; k*k + j*j + i*i < n; ++k) {//每一个循环变量的取值均以上一个为基础，在一遇到满足条件就输出的情况下，就能输出升序排列的第一个 
                if(int(pow(int(pow(n-i*i-j*j-k*k, 0.5)), 2)) == (n-i*i-j*j-k*k)) {
                    cout << i << ' ' << j << ' ' << k << ' ' << pow(n-i*i-j*j-k*k, 0.5);
                    return 0;
                }
            }
        }
    }
}
