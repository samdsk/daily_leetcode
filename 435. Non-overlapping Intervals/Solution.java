class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        int left = intervals[0][0];
        int right = intervals[0][1];

        int n = intervals.length;
        int count = 0;

        for(int i=1;i<n;i++){
            int next_left = intervals[i][0];
            int next_right = intervals[i][1];

            if(next_left >= left && next_left < right || next_right > left && next_right <= right){
                count++;
                left = Math.max(left, next_left);
                right = Math.min(right, next_right);
            }else{
                left = next_left;
                right = next_right;
            }
            
        }

        // [[1,2],[1,3],[2,3],[3,4]]
        return count;
    }
}