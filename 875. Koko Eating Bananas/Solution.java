import java.util.Arrays;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        while(left<=right){
            int mid = left + (right-left)/2;
            if(isEnough(piles, mid, h)){
                right = mid-1;
            }else{
                left = mid+1;
            }

        }

        return left;
    }

    private boolean isEnough(int[] piles,int m,int h){
        long total = 0;
        for(int i : piles){
            if(i%m!= 0) total++;
            total += (long) i/m;
        }

        return total<= (long)h;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minEatingSpeed(new int[]{3,6,7,11}, 8));
        System.out.println(new Solution().minEatingSpeed(new int[]{30,11,23,4,20}, 5));
        System.out.println(new Solution().minEatingSpeed(new int[]{30,11,23,4,20}, 6));
        System.out.println(new Solution().minEatingSpeed(new int[]{805306368,805306368,805306368}, 1000000000));
    }
}