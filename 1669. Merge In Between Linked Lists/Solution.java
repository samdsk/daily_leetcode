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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = new ListNode(0,list1);
        ListNode left = null;
        ListNode right = null;

        for(int i=0;i<a-1 && list1 != null;i++){
            list1 = list1.next;
        }

        left = list1;

        for(int i=a-1;i<b && list1 != null;i++){
            list1 = list1.next;
        }
        
        right = list1.next;
        left.next = list2;

        while(list2.next != null){
            list2 = list2.next;
        }

        list2.next = right;

        return head.next;
    }
}