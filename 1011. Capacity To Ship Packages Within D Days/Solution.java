import java.time.temporal.WeekFields;
import java.util.Arrays;

/**
 * Solution
 */
public class Solution {

    public int shipWithinDays(int[] weights, int days) {        
        int max = Arrays.stream(weights).max().getAsInt();
        System.out.println("maxiniziale "+max);
        
        int index = 0;
        int count = 0;
        
        while(true){
            while(index<weights.length){
                index = sum(weights,index,max);
                count++;
            }

            if(count <= days) {                
                break;
            }
            if(index>=weights.length){                
                count = 0;
                max++;
                index = 0;
            }

        }

        return max;
    }

    public static int sum(int[] n,int i,int limit){
        int sum = 0;
        while(i<n.length){            
            if(sum+n[i]>limit) break;
            sum += n[i];
            i++;
        }
        return i;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
        System.out.println(new Solution().shipWithinDays(new int[]{3,2,2,4,1,4}, 3));
        System.out.println(new Solution().shipWithinDays(new int[]{1,2,3,1,1}, 4));
    }
}