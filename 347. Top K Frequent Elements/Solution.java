import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k  == nums.length) return nums;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i<nums.length;i++){
            int temp = nums[i];
            map.put(temp,map.getOrDefault(temp,0)+1);
        }

        Queue<Integer> pq = new PriorityQueue<Integer>((a,b)-> map.get(a)-map.get(b));

        for(int key : map.keySet()){
            pq.add(key);
            if(pq.size()>k) pq.poll();
        }

        int[] ans = new int[k];
        int index = k-1;

        while(!pq.isEmpty() && index>=0){
            ans[index--] = pq.poll();
        }

        return ans;
    }
}