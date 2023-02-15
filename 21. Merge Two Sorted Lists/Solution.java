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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();

        if(list1 == null && list2 == null) return null;

        ListNode output = head;

        while(list1 != null && list2 != null){
            int temp;
            if(list1.val<=list2.val){
                temp = list1.val;
                
                list1 = list1.next;
                
            }else{
                temp = list2.val;
                list2 = list2.next;
                
            }
            System.out.println(temp);
            head.val = temp;
            head.next = (list2 == null && list1 == null) ? null : new ListNode();
            head = head.next;
        }

        while(list1!= null){
            head.val = list1.val;
            head.next = (list1.next == null) ? null : new ListNode();
            head = head.next;
            list1 = list1.next;
        }

        while(list2 != null){
            head.val = list2.val;            
            head.next = (list2.next == null) ? null : new ListNode();
            head = head.next;
            list2 = list2.next;
        }

        return output;
    }
}