import java.util.Arrays;

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];

        for(int i = 1;i<arr.length;i++){
            if(Math.abs(arr[i] - arr[i-1]) != diff) return false;
        }

        return true;
    }
}