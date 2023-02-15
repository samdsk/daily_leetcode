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
        if(list1 == null || list2 == null)
            return list1 == null ? list2 : list1;

        ListNode list;

        if(list1.val < list2.val){            
            list = new ListNode(list1.val);
            list.next = mergeTwoLists(list1.next, list2);
        }else{
            list = new ListNode(list2.val);
            list.next = mergeTwoLists(list1, list2.next);
        }

        return list;
    }
}