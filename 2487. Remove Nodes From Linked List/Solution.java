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
    public ListNode removeNodes(ListNode head) {
        ListNode rev = reverse(head);
        ListNode cur = rev.next;
        ListNode prev = rev;
        int max = rev.val;
        // [8,13,2,5]
        while(cur != null){
            if(cur.val < max){
                prev.next = cur.next;
            }else{
                max = cur.val;
                prev = prev.next;
            }
            
            cur = cur.next;
        }        

        return reverse(rev);
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;

        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;

        }

        return prev;
    }
}