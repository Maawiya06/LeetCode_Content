class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

       
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 2: move `prev` to the node before `left`
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 3: reverse sublist [left, right]
        ListNode curr = prev.next;  // node at `left`
        ListNode next = null;

        for (int i = 0; i < right - left; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        // Step 4: return new head
        return dummy.next;
    }
}
