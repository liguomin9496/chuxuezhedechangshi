/*#include<iostream>
using namespace std;
    void scheduleTable(int[][] table, int n) {
        if (n == 1) {
            table[0][0] = 1;
        } else {
        ��������������
            nֵ�ı仯��8  4  2  1
            mֵ�ı仯��4  2  1  1  
            int m = n / 2;
            scheduleTable(table, m);
            //��������������
            for (int i = 0; i < m; i++) {
                for (int j = m; j < n; j++) {
                    table[i][j] = table[i][j - m] + m;
                }
            }
            //��������������
            for (int i = m; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    table[i][j] = table[i - m][j] + m;
                }
            }
            //��������������
            for (int i = m; i < n; i++) {
                for (int j = m; j < n; j++) {
                    table[i][j] = table[i - m][j - m];
                }
            }
        } 

    public static void main(String[] args) {
        int[][] table = new int[8][8];
        int n = 8;
        SportsSchedule schedule = new SportsSchedule();
        schedule.scheduleTable(table, n);
        int c = 0;
        //��ӡ��ά����
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(table[i][j] + " ");
                c++;//ÿ��ӡһ������c++
                if (c % n == 0) {//˵����ӡһ����
                    System.out.println();//����
                }
            }
        }
    }
}*/
#include<iostream>
using namespace std;
void ScheduleTable(int table[][],int n){
	if(n==1)
		table[0][0]=1;
	else{
		int m=n/2;
		ScheduleTable(table,m);
		//������� 
		for(int i=0;i<n;i++)
			for(int j=m;j<n;j++)
				table[i][j]=table[i][j-m]+m;
		//�������
		for(int i=m;i<n;i++)
			for(int j=0;j<m;j++)
				table[i][j]=table[i-m][j+m];
		//�������
		for(int i=m;i<n;i++)
			for(int j=m;j<n;j++)
				table[i][j]=table[i-m][j-m]; 
	}	
}
int main(){
	int n,*table;
	cin>>n;
	table = new int [n][n];
	ScheduleTable(table,n);
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			cout<<table[i][j]<<" ";
		}
		cout<<endl;
	}
	return 0;	
}

