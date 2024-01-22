class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;

        int temp[] = new int[n+1];

        for(int i=0;i<n;i++){
            temp[nums[i]]++;   
        }

        int dup = 0;
        int missing = 0;
        for(int i=1;i<=n;i++){
            if(temp[i] == 2) dup = i;
            if(temp[i] == 0) missing = i;
        }

        return new int[]{dup,missing};
    }
}