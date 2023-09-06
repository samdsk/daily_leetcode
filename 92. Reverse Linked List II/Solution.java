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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null) return head;
        
        ListNode start = head;

        for(int i=1;i<left && start != null;i++)
            start = start.next;

        while(left < right)
            reverse(start,left,right--);

        return head;
    }

    private void reverse(ListNode current,int left, int right){
        if(left == right) return;

        int val = current.val;
        current.val = current.next.val;
        current = current.next;
        current.val = val;

        reverse(current,left,right-1);
    }
}