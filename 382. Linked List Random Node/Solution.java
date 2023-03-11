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
    private ListNode head;

    public Solution(ListNode head) {
        this.head = head;

    }
    
    public int getRandom() {
        int scope = 1;
        int output = 0;

        ListNode curr = head;

        while(curr != null){
            if(Math.random() < (1.0 / scope)){
                output = curr.val;
            }
            scope++;
            curr = curr.next;
        }

        return output;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */