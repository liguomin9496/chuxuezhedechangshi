 #include<iostream>
 #include<string>
 using namespace std;
 bool isAnagram(string s, string t) {//string类型的底层实现是使用的Char数组，可以使用下标的方式访问string类型的变量 
        int slen = s.size();
        int tlen = t.size();
        if(slen != tlen)
            return false;
        int alp[26] = {0};
        for(int i=0;i<slen;i++){
            alp[s[i] - 'a']++;
            alp[t[i] - 'a']--;            
        }
        for(int i=0;i<26;i++){
            if(alp[i] != 0)               
                return false;
        }
        return true;
    }
 int main(){
 	cout<<isAnagram("liguomin","guominli"); 	
 } 
 
