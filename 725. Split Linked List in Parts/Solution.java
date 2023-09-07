import java.util.List;

class Solution {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode cursor = head;
        int size = 0;

        while(cursor != null){
            cursor = cursor.next;
            size++;
        }
        int listWidth = size/k;
        int remainder = size % k;

        ListNode[] ans = new ListNode[k];
        int index = 0;

        while(head != null){
            int i = 0;
            ans[index] = head;

            while(head!= null && i < listWidth + (index<remainder ? 1 : 0)-1 ){
                head = head.next;
                i++;
            }
            if(head!=null){
                ListNode prev = head;
                head = prev.next;
                prev.next = null;
            }
            index++;

        }

        return ans;
    }
}