/*#include <iostream>
#include <algorithm>
int cnt=0;
using namespace std;

struct date{
    int year, month, day;
};

bool isyn(int y){
    return (y % 4 == 0) || (y % 100 && y % 400 == 0);
}

void print(const date &d){
    printf("%02d-%02d-%02d\n", d.year, d.month, d.day);
}

bool compare(const date &d1, const date &d2){//这种比较方式也很有趣和新颖 
    if(d1.year != d2.year){
        return d1.year < d2.year;
    }
    if(d1.month != d2.month){
        return d1.month < d2.month;
    }
    return d1.day < d2.day;
}

bool check(const date &d){
    static int month_days[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    if(isyn(d.year)){
        month_days[2] = 29;
    }else{
        month_days[2] = 28;
    }

    if(d.year < 1960 || d.year > 2059){
        return false;
    }
    if(d.month < 1 || d.month > 12){
        return false;
    }
    if(d.day < 1 || d.day > month_days[d.month]){
        return false;
    } 
    
}
bool CheckEquals(const date d[],int i){
	for(int j=i+1;j<6;j++){
		if(d[i].year==d[j].year){
			if(d[i].month==d[j].month && d[i].day==d[j].day)
				return false;
		}
	}
	return true;
}
int main()
{
    int aa, bb, cc;
    scanf("%d/%d/%d", &aa, &bb, &cc);
    date d[6] = {
        {2000 + aa, bb, cc},
        {1900 + aa, bb, cc},
        {2000 + cc, aa, bb},
        {1900 + cc, aa, bb},
        {2000 + cc, bb, aa},
        {1900 + cc, bb, aa}
    };
    sort(d, d + 6, compare);//注意sort函数的这种用法 
    for(int i = 0; i < 6; ++ i){
        if(check(d[i])){
        	if(CheckEquals(d,i))
            	print(d[i]);
        }
    }
    return 0;
}*/
#include<iostream>
#include<algorithm>
using namespace std;
struct Date{
	int year;
	int month;
	int day;
};
void Print(Date&d){
	 printf("%02d-%02d-%02d\n", d.year, d.month, d.day);
}
bool IsYear(int year){
	if((year%4==0 && year%100!=0) || year%400==0)
		return true;
	return false;
}
bool Compare(const Date&d1,const Date&d2){
	if(d1.year!=d2.year)
		return d1.year<d2.year;
	if(d1.month!=d2.month)
		return d1.month<d2.month;
	return d1.day<d2.day;
}
bool CheckDate(Date&d){
	int months[13]={0,31,28,31,30,31,30,31,31,30,31,30,31};
	if(IsYear(d.year))
		months[2]=29;
	else
		months[2]=28;
	if(d.year<1960 || d.year>2059)
		return false;
	if(d.day<1 || d.day>months[d.month])
		return false;
	return true;
}
bool checkEquals(Date date[],int i){
	for(int j=i+1;j<6;j++){
		if(date[i].year==date[j].year)
			if(date[i].month==date[j].month && date[i].day==date[j].day)
				return false;
	}
	return true;
}
int main(){
	int a,b,c;
	scanf("%d/%d/%d", &a, &b, &c);
	Date date[6]={
	{2000+a,b,c},
	{2000+c,a,b},
	{2000+c,b,a},
	{1900+a,b,c},
	{1900+c,a,b},
	{1900+c,b,a},
	};
	sort(date,date+6,Compare);
	for(int i=0;i<6;i++){
		if(CheckDate(date[i]))
			if(checkEquals(date,i))	
				Print(date[i]);	
	}
	return 0;	
} 
