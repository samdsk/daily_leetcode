import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long cost = 0;

        PriorityQueue<Integer> pq_left = new PriorityQueue<>();
        PriorityQueue<Integer> pq_right = new PriorityQueue<>();

        for (int i = 0; i < candidates && i < n; i++) {
            pq_left.offer(costs[i]);
        }

        for (int i = Math.max(candidates, n - candidates); i<n; i++) {
            pq_right.offer(costs[i]);
        }

        // System.out.println(Arrays.toString(pq_left.toArray()));
        // System.out.println(Arrays.toString(pq_right.toArray()));

        int left = candidates;
        int right = n - candidates - 1;

        for (int i = 0; i < k; i++) {
            if(pq_right.isEmpty() || !pq_left.isEmpty() && pq_left.peek() <= pq_right.peek()){
                cost += pq_left.poll();
                if(left <= right) pq_left.offer(costs[left++]);
            }else{
                cost += pq_right.poll();
                if(left <= right) pq_right.offer(costs[right--]);
            }
        }

        return cost;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().totalCost(new int[]{17,12,10,2,7,2,11,20,8},3,4));
        System.out.println(new Solution().totalCost(new int[]{1,2,4,1},3,3));
    }
}