public class Solution {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //System.out.println(head);

        //if there is a loop fast and slow will eventually overlap and will break the loop
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast) break;
        }
        // if fast cursor null which means there is no cycle
        if(fast == null || fast.next == null) return null;

        //loop through the list until head and slow match up
        while(head != slow){
            head = head.next;
            slow = slow.next;
        }

        return head;
    }
}