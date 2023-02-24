import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int minimumDeviation(int[] nums) {        

        int min = Integer.MAX_VALUE;
        PriorityQueue<Integer> queue = new PriorityQueue<>(nums.length,Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if(nums[i] % 2 == 0){
                queue.add(nums[i]);
            }else{
                queue.add(nums[i]*2);
                n = n*2;                
            }
            min = Math.min(min, n);
        }

        int res = Integer.MAX_VALUE;

        while(queue.poll() % 2 == 0){
            int max = queue.poll();
            res = Math.min(res,max-min);
            int newMin = max/2;
            queue.offer(newMin);
            min = Math.min(newMin,min);
        }

        res = Math.min(queue.peek() - min, res);
        return res;
        
    }
}