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
    public ListNode reverseKGroup(ListNode head, int k) {
         
         if(head == null || head.next == null){
            return head;
         }

         // count k
         ListNode temp = head;
         int count = 0;
         while(temp != null && count < k){
            temp = temp.next;
            count++;
         }

        if(count < k){
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode nextNode = null;
        int pos = 0;
        while(pos < k && curr != null){
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            pos++;
        }

        if(curr != null){
            head.next = reverseKGroup(curr, k);
        }
        return prev;
    }
}