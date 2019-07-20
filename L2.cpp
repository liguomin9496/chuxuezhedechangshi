#include<iostream>
#include<stdio.h>
#include<windows.h>
#include<conio.h>
#include<math.h>
using std::cout;
using std::endl;
#include<cmath>
#include<time.h>  
#define m 0.3
#define n 0.6
#define t 1.8
#define r 1.0   //some ratios  
#include<conio.h> 
char randk(); 
void main()
{
        double myX,myY;
        double yourX,yourY;
        double width=4.0; //width
        double heigh=1.5; //heigh
        int i=0;
        long f=0;
        char s[10]="color ";
        puts("\n\n\n\n\n\n\n ");     
        cout<<"我能想到最浪漫的事"<<endl;
        cout<<"                就是和你一起慢慢变老"<<endl;        
        puts("\n\a");
        for(i=0;i<999;i++)
		{
			s[7]=randk();
            s[6]=randk();//背景为d淡红色
            system(s);//调用cmd的color命 
            if(i==0)
			{
                for(myY=heigh,yourY=heigh;myY>=-1.0,yourY>=-1.0;myY-=0.1,yourY-=0.1)// y position
				{
                     for(myX=-3.0,yourX=-3.0;myX,yourX<=width;myX+=0.1,yourX+=0.1)// x position 
					 {
                         if((pow(n*pow(yourX,2)+t*pow(yourY,2)-1.0,3)-t*pow(yourX,2)*pow(yourY,3)>=0)
                         &&(pow(m*pow(myX,2)+r*pow(myY,2)-1.0,3)-r*pow(myX,2)*pow(myY,3)<0))        
                         //the function (n*x^2+t*y^2-1)^3-t*x^2*y^3=0
		                     cout<<"*";
                         else
                             cout<<" ";
					 }
                  cout<<endl;
  
				}
             cout<<" Dear Honey"<<'\t';
	         cout<<"I LOVE YOU"<<endl;
             cout<<"18-09-05"<<endl;
			}
         f=0;
         while(f<21448325){
         f=f+1;
		 f=f-1;
         f=f+1;
		 }
}
         
}
  
		char randk()
		{     
            char a=0; 
            a=(char) abs( rand()%16);
            if(a>=10)
			{
                a-=10;
                a+=97;
			}
            else
                a+=48;          
        return a;
}