import java.util.Stack;

class Solution {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int overflow = 0;

        int total = 0;

        ListNode ans = new ListNode();

        while(!s1.isEmpty() || !s2.isEmpty()){
            if(!s1.isEmpty()) total += s1.pop();
            if(!s2.isEmpty()) total += s2.pop();

            ans.val = total % 10;
            overflow = total / 10;

            ListNode node = new ListNode(overflow);
            node.next = ans;
            ans = node;
            total = overflow;
        }

        return overflow == 0 ? ans.next : ans;
    }
}