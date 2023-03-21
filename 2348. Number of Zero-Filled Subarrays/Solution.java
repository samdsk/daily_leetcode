class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int count = 0;
        long res = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) count++;
            else{
                count = 0;
            }
            res += count;
        }

        return res;
        
    }

    public static void main(String[] args) {
        System.out.println(new Solution().zeroFilledSubarray(new int[]{1,3,0,0,2,0,0,4}));
        System.out.println(new Solution().zeroFilledSubarray(new int[]{0,0,0,2,0,0}));
        System.out.println(new Solution().zeroFilledSubarray(new int[]{2,10,2019}));
    }
}