

class Solution {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode current = newHead;

        while(current.next != null && current.next.next != null){
            ListNode first = current.next;
            ListNode second = current.next.next;

            current.next = second;
            first.next = second.next;
            second.next = first;
            current = current.next.next;
        }

        return newHead.next;
    }
}