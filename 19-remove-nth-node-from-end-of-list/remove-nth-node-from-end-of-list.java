/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    int getlength(ListNode head){
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        } 

        return len;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = getlength(head);
        int agesLength = length - n + 1;


        if(agesLength == 1){
            return head.next;
        }

        ListNode curr = head;
        ListNode prev = null;

        for(int i = 1; i < agesLength; i++){
            prev = curr;
            curr = curr.next;
        }

        prev.next = curr.next;
        return head;
    }
}