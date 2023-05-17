class Solution {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int pairSum(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        ListNode current = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            current = slow;
            slow = slow.next;

            current.next = prev;
            prev = current;

        }

        int max = Integer.MIN_VALUE;

        while(slow != null || prev != null){
            int x = prev.val;
            int y = slow.val;
            // System.out.println(x+" "+y);
            max = Math.max(max, x+y);
            slow = slow.next;
            prev = prev.next;
        }

        return max;

    }

}