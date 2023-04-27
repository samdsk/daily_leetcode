


class Solution {
    public int getDecimalValue(ListNode head) {
        int ans = head.val;

        while(head.next != null){
            head = head.next;
            ans += ans * 2 + head.val;

        }

        return ans;
    }
    // binary manipulation
    public int getDecimalValue_bin(ListNode head) {
        int ans = head.val;

        while(head.next != null){
            head = head.next;
            ans = ans << 1 | head.val;
        }

        return ans;
    }

}

// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}