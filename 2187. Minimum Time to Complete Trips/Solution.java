import java.util.Arrays;
class Solution {
    public long minimumTime(int[] time, int totalTrips) {      

        long max = Arrays.stream(time).max().getAsInt();
        long rightBound = totalTrips*max;
        long leftBound = 1;
        while(leftBound<rightBound){
            long tempTotal = 0;
            long mid = leftBound + (rightBound-leftBound)/2;

            for(int i =0;i<time.length;i++){  
                tempTotal+=mid/time[i];
            }
            
            if(tempTotal>=totalTrips) rightBound=mid;
            else leftBound=mid+1;
        }
        
        return leftBound;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumTime(new int[]{5,10,10}, 9));
        System.out.println(new Solution().minimumTime(new int[]{1,2,3}, 5));
        System.out.println(new Solution().minimumTime(new int[]{9,3,10,5}, 2));
        System.out.println(new Solution().minimumTime(new int[]{2}, 1));
    }
}