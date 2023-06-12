import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int i = 0;

        while(i<nums.length){
            StringBuilder str = new StringBuilder();

            str.append(nums[i]);
            int temp = nums[i];

            while((i+1<nums.length) && (nums[i+1] - nums[i] == 1)) i++;

            if(temp != nums[i]) str.append("->"+nums[i]);

            ans.add(str.toString());
            i++;

        }

        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().summaryRanges(new int[]{0,2,3,4,6,8,9}));
    }
}