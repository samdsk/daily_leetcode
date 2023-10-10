import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans = n;

        Set<Integer> unique = new HashSet<>();

        for(int x : nums)
            unique.add(x);

        int[] filteredArray = new int[unique.size()];

        int index = 0;
        for(int x : unique)
            filteredArray[index++] = x;

        Arrays.sort(filteredArray);
        
        for (int i = 0; i < filteredArray.length; i++) {
            int left = filteredArray[i];
            int right = left + n - 1;
            int j = binarySearch(filteredArray, right);
            int count = j - i;
            ans = Math.min(ans, n - count);
        }


        return ans;
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length;

        while(left < right){
            int mid = left + (right - left)/2;
            if(target < nums[mid]) right = mid;
            else left = mid+1;
        }

        return left;
    }

}