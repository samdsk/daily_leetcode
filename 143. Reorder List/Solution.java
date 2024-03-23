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
    public void reorderList(ListNode head) {
        // find middle
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // middle node of the list
        ListNode mid = slow;

        //reverse starting from middle
        ListNode prev = null;
        ListNode cur = mid;

        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        // reversed list
        ListNode rev = prev;

        // alternate two lists        
        cur = head;
        ListNode head2 = head.next;
        int count = 0;

        while(head2 != null && rev != null){
            if(count%2==0){
                cur.next = rev;
                rev = rev.next;
            }else{
                cur.next = head2;
                head2 = head2.next;
            }
            count++;
            cur = cur.next;
        }
    }
}