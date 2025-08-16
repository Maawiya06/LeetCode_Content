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
    public ListNode helperfunction(ListNode prev, ListNode curr){
        if(curr == null){
            return prev;
        }

        ListNode nextNode = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextNode;

        ListNode ans = helperfunction(prev, curr);
        return ans;
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        return helperfunction(prev, curr);
    }
}