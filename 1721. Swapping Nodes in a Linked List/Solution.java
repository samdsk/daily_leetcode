class Solution {

    //  Definition for singly-linked list.

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp = head;

        int count = 1;

        while(count<k){
            temp = temp.next;
            count++;
        }

        ListNode firstValue = temp;
        ListNode secondValue = head;

        while(temp.next != null){
            temp = temp.next;
            secondValue = secondValue.next;
        }

        int tempVal = firstValue.val;
        firstValue.val = secondValue.val;
        secondValue.val = tempVal;


        return head;
    }
}