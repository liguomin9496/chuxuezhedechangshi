//773535,�������������1����д�� 2�����������demo�����б��ֳ��˽�Ȼ��ͬ������Ч������������Ż�֮�����ڱ����˺ܶ಻��Ҫ��ѭ�������������ڱ�̵���
//һ����Ҫ����ѭ�����������ã�һ��Ҫ�ڿ��ܵ�����£�������Сѭ���Ŀ��������� �����Լ�д��demo�����е�773535�Լ�֮��ʱ������δ�Ż�ѭ�����������K��ƽ��ֵ
//���ھ޴������int�͵�ȡֵ��Χ��Ȼ��������Ĳ����������773535֮��Ľ��ȫ������ ����AC����Ȼ������ll�����һ�������⣬����������Ļ���
//���ɶԳ����еĸ��ֱ����������Ż���ϰ�ߣ��Լ��ٿɱ���Ĵ��󣬺ͽ�Լʱ���Լ��ռ䣡�� 
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
	cout<<"��Ч���ݣ�"<<endl; 
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
            for(int k = j; k*k + j*j + i*i < n; ++k) {//ÿһ��ѭ��������ȡֵ������һ��Ϊ��������һ�����������������������£���������������еĵ�һ�� 
                if(int(pow(int(pow(n-i*i-j*j-k*k, 0.5)), 2)) == (n-i*i-j*j-k*k)) {
                    cout << i << ' ' << j << ' ' << k << ' ' << pow(n-i*i-j*j-k*k, 0.5);
                    return 0;
                }
            }
        }
    }
}
