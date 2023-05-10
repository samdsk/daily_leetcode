class Solution {
    public int[][] generateMatrix(int n) {
        int rows = n-1;
        int cols = n-1;
        int r = 0;
        int c = 0;
        int[][] ans = new int[n][n];
        int count = 1;

        while(r<=rows && c<=cols){
            for(int i = c;i<=cols;i++){
                ans[r][i] = count++;
            }
            r++;

            for(int i = r;i<=rows;i++){
                ans[i][cols] = count++;
            }
            cols--;

            if(r<=rows){
                for(int i = cols;i>=c;i--){
                    ans[rows][i] = count++;
                }
            }
            rows--;

            if(c<=cols){
                for(int i = rows;i>=r;i--){
                    ans[i][c] = count++;
                }
            }
            c++;
        }

        return ans;
    }
}