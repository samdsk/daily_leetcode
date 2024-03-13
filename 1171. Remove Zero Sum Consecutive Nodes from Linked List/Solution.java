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
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer,ListNode> map = new HashMap<>();
        ListNode front = new ListNode(0,head);
        ListNode cur = front;
        int sum = 0;

        while(cur != null){

            sum += cur.val;

            if(map.containsKey(sum)){
                ListNode prev = map.get(sum);
                cur = prev.next;

                int p = sum + cur.val;
                while(p != sum){
                    map.remove(p);
                    cur = cur.next;
                    p += cur.val;
                }
                prev.next = cur.next;
            }else{
                map.put(sum,cur);
            }

            cur = cur.next;
        }

        return front.next;
    }
}