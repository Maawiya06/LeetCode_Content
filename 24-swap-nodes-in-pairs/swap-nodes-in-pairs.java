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
    public ListNode swapPairs(ListNode head) {
        // if(head == null || head.next == null) return head;
        // ListNode temp = head.next;
        // head.next = swapPairs(temp.next);
        // temp.next = head;
        // return temp;

        ListNode temp = new ListNode(0, head);
        ListNode prev = temp;
        ListNode curr = head;

        while(curr != null && curr.next != null){
            ListNode ans = curr.next.next;
            ListNode second = curr.next;

            second.next = curr;
            curr.next = ans;
            prev.next = second;

            prev = curr;
            curr = ans;
        }

        return temp.next;
    }
}