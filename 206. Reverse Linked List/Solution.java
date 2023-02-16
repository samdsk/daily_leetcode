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
    public ListNode reverseList(ListNode head) {
        return reverse(head,null);
    }

    private static ListNode reverse(ListNode head,ListNode acc){
        if(head == null) return acc;
        return reverse(head.next,acc = new ListNode(head.val,acc));
    }
}