/**
 * Intuition and Algorithm
 * When traversing the list with a pointer slow, 
 * make another pointer fast that traverses twice as fast. 
 * When fast reaches the end of the list, slow must be in the middle.
 */

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}