import java.util.Arrays;

class Solution {
    public int[] getAverages(int[] nums, int k) {
        if(k==0) return nums;

        int n = nums.length;
        int[] ans = new int[n];

        long sum = 0;
        int div = (k*2) + 1;

        Arrays.fill(ans,-1);
        if(div>n) return ans;

        for (int i = 0; i < div; i++) {
            sum += nums[i];
        }

        ans[k] = (int) (sum / div);

        for (int i = div; i < n; i++) {
            sum = sum - nums[i-div] + nums[i];
            ans[i-k] = (int) (sum / div);
        }

        return ans;


    }
}