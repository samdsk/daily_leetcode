class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int i = 0;

        List<int[]> ans = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];

        while(i<n && intervals[i][1] < start){
            ans.add(intervals[i]);
            i++;
        }

        while(i<n && end >= intervals[i][0]){
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }

        ans.add(new int[]{start,end});

        while(i<n){
            ans.add(intervals[i++]);
        }

        return ans.toArray(new int[ans.size()][2]);
    }
}