class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;

        int[] ans = new int[n];

        int[] lis = new int[n];
        int lisLength = 0;

        for (int i = 0; i < n; i++) {
            int height = obstacles[i];

            int index = binarySearch(lis,height,lisLength);
            if(index == lisLength) lisLength++;

            lis[index] = height;
            ans[i] = index+1;
        }

        return ans;

    }

    private int binarySearch(int[] arr, int target, int right){
        if(right == 0) return 0;
        int left = 0;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(arr[mid] <= target) left = mid +1;
            else right = mid;
        }

        return left;
    }
}