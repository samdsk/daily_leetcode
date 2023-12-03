class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int m = points.length;
        int sum = 0;
        for (int i = 1; i < m; i++) {
            int x = points[i-1][0];        
            int y = points[i-1][1];        
            int a = points[i][0];        
            int b = points[i][1];   
            
            sum += Math.max(Math.abs(x-a), Math.abs(y-b));
        }

        return sum;
    }
}