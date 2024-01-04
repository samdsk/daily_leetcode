import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minOperations(int[] nums) {
        Map<Integer,Integer> freqs = new HashMap<>();

        for(int n : nums){
            freqs.put(n,freqs.getOrDefault(n,0)+1);
        }

        int sum = 0;

        for(int n : freqs.values()){
            if(n == 1) return -1;

            if(n%3 != 0) sum++;

            sum += n/3;            
        }

        return sum;
    }
}