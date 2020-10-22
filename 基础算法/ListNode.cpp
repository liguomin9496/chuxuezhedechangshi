#include<iostream>
using namespace std;
struct ListNode {
      int val;
      ListNode *next;
      ListNode() : val(0), next(nullptr) {}
      ListNode(int x) : val(x), next(nullptr) {}
      ListNode(int x, ListNode *next) : val(x), next(next) {}
}; 
ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode *p,*q,*target;
        p = head->next;
        q = head->next;
        int len=1;
        int i=1;
        while(p->next){
            p = p->next;
            len++;
        }
        while(q->next != NULL && i<len-n){
            q = q->next;
            i++;
        }
        target = q->next;
        q->next = q->next->next;
        delete target;
        return head;
}
int main(){
	
}
