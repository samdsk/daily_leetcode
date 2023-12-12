class Solution {
    public int maxProduct(int[] nums) {
        int M = nums[0];
        int m = nums[1];

        if(m>M){
            int temp = M;
            M = m;
            m = temp;
        }

        for(int i=2;i<nums.length;i++){
            if(nums[i]>M){
                int temp = M;
                M = nums[i];
                m = temp;
            }else if(nums[i]>m){
                m = nums[i];
            }
        }

        return (M-1) * (m-1);
    }    
}