class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[0],b[0]));
        int left = points[0][0];
        int right = points[0][1];

        int n = points.length;
        int count = 1;

        for(int i=1;i<n;i++){
            if(points[i][0] >= left && points[i][0] <= right || points[i][1] >= left && points[i][1] <= right){
                left = Math.max(left, points[i][0]);
                right = Math.min(right, points[i][1]); 
            }else{
                left = points[i][0];
                right = points[i][1]; 
                count++;
            }       

        }

        return count;
    }
}