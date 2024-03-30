class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {

        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        int leftFar = 0;
        int leftNear = 0;
        
        for(int right=0; right<n; right++){
            int key = nums[right];
            map.put(key,map.getOrDefault(key,0)+1);

            int size = map.size();
            int leftKey = nums[leftNear];

            while(size>k){
                leftKey = nums[leftNear];
                map.put(leftKey,map.get(leftKey)-1);

                if(map.get(leftKey) < 1){
                    map.remove(leftKey);
                    size = map.size();
                }

                leftNear++;
                leftFar = leftNear;
            }

            leftKey = nums[leftNear];
            while(map.get(leftKey) > 1){
                map.put(leftKey, map.get(leftKey)-1);
                leftKey = nums[++leftNear];
            }

            if(size == k)
                ans += leftNear - leftFar + 1;

        }

        return ans;
    }
}