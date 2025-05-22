/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode* a = headA;
        ListNode* b = headB;

        while(a->next && b->next){
            if(a == b){
                return a;
            }
            a = a->next;
            b = b->next;
        }

        if(a->next == 0){
            // B LL is larger
            // we need to find the length of each
            int blen = 0;
            while(b->next){
                blen++;
                b = b->next;
            }
            while(blen--){
                headB = headB->next;
            }
        }

        else{
            // A LL is larger
            // we need to find the length of each
            int alen = 0;
            while(a->next){
                alen++;
                a = a->next;
            }
            while(alen--){
                headA = headA->next;
            }
        }

        while(headA != headB){
            headA = headA->next;
            headB = headB ->next;
        }

        return headA;
    }
};