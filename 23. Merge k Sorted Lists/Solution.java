import java.util.PriorityQueue;

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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length < 1) return null;

        ListNode output = new ListNode();
        ListNode cur = output;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, (a,b)-> a.val-b.val);

        // initialize the pq with the HEADs of the array of ListNodes
        for(ListNode node : lists){
            if(node != null)
                pq.offer(node);
        }

        while(!pq.isEmpty()){
            cur.next = pq.poll();
            cur = cur.next;
            // if the extracted node from the pq is not null 
            // means that it has other values (List has other nodes connected to it)
            // then I re-add it to the queue until every initial ListNode has been traversed
            if(cur.next != null){
                pq.offer(cur.next);
            }
        }

        // the real first element of the list is output.next
        // because the first element is a dummy used to return the head of the list
        return output.next;
    }
}