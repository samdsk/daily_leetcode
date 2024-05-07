/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode doubleIt_optimized(ListNode head) {
        if (head.val > 4) {
            head = new ListNode(0, head);
        }

        ListNode cur = head;

        while (cur != null) {
            cur.val = (cur.val * 2) % 10;

            if (cur.next != null && cur.next.val > 4) {
                cur.val++;
            }

            cur = cur.next;
        }

        return head;
    }

    public ListNode doubleIt(ListNode head) {
        ListNode rev = reverse(head);
        ListNode cur = rev;
        ListNode prev = null;
        int overflow = 0;

        while (cur != null) {
            int doubled = cur.val * 2;
            cur.val = (doubled % 10) + overflow;
            overflow = doubled / 10;
            prev = cur;
            cur = cur.next;
        }

        if (overflow > 0) {
            prev.next = new ListNode(overflow);
        }

        return reverse(rev);
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode cur = node;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}