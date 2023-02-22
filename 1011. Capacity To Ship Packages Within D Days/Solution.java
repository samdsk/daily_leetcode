import java.util.Arrays;

/**
 * Solution
 */
public class Solution {

    public int shipWithinDays(int[] weights, int days) {        
        int total_weight = Arrays.stream(weights).sum();
        int max_capacity = Arrays.stream(weights).max().getAsInt();
        
        int left = max_capacity, right = total_weight;

        while(left<right){
            int mid = left + (right -left)/2;
            if(isPossible(weights, days, mid)){
                right = mid;
            }else left = mid+1;
        }

        return left;
    }

    public static boolean isPossible(int[] weights,int days,int capacity){
        int temp_days = 1, temp_sum = 0;

        for(int w : weights){
            temp_sum += w;
            if(temp_sum>capacity){
                temp_days++;
                temp_sum = w;
            }
        }

        return temp_days<=days;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
        System.out.println(new Solution().shipWithinDays(new int[]{3,2,2,4,1,4}, 3));
        System.out.println(new Solution().shipWithinDays(new int[]{1,2,3,1,1}, 4));
    }
}