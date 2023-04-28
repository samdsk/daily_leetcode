import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!set.add(nums[i])) return true;
        }

        return false;
    }
}

// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         Arrays.sort(nums);

//         int prev = nums[0];

//         for (int i = 1; i < nums.length; i++) {
//             if(nums[i] == prev) return true;
//             prev = nums[i];
//         }

//         return false;
//     }
// }