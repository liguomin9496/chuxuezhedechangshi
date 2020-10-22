/*#include<iostream>
using namespace std;
    void scheduleTable(int[][] table, int n) {
        if (n == 1) {
            table[0][0] = 1;
        } else {
        填充左上区域矩阵
            n值的变化：8  4  2  1
            m值的变化：4  2  1  1  
            int m = n / 2;
            scheduleTable(table, m);
            //填充右上区域矩阵
            for (int i = 0; i < m; i++) {
                for (int j = m; j < n; j++) {
                    table[i][j] = table[i][j - m] + m;
                }
            }
            //填充左下区域矩阵
            for (int i = m; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    table[i][j] = table[i - m][j] + m;
                }
            }
            //填充右下区域矩阵
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
        //打印二维数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(table[i][j] + " ");
                c++;//每打印一个数，c++
                if (c % n == 0) {//说明打印一行了
                    System.out.println();//换行
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
		//填充右上 
		for(int i=0;i<n;i++)
			for(int j=m;j<n;j++)
				table[i][j]=table[i][j-m]+m;
		//填充左下
		for(int i=m;i<n;i++)
			for(int j=0;j<m;j++)
				table[i][j]=table[i-m][j+m];
		//填充右下
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

