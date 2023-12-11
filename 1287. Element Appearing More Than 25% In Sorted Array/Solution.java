class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int[] candidates = {arr[n/4], arr[n/2], arr[3*n / 4]};
        int target = n/4;

        for(int candidate : candidates){
            int left = findLeft(arr, candidate);
            int right = findRight(arr, candidate) - 1;

            if(right - left + 1 > target) 
                return candidate; 
        }


        return -1;
    }

    private int findLeft(int[] arr, int target){
        int left = 0;
        int right = arr.length;

        while(left < right){
            int m = left + (right - left) / 2;
            if(arr[m] >= target)
                right = m;
            else
                left = m + 1;
        }

        return left;
    }

    private int findRight(int[] arr, int target){
        int left = 0;
        int right = arr.length;

        while(left < right){
            int m = left + (right - left) / 2;
            if(arr[m] > target)
                right = m;
            else
                left = m + 1;
        }

        return left;
    }
}