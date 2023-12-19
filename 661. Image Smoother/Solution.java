class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;

        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int count = 0;

                for (int r = i-1; r < i+2; r++) {
                    for (int c = j-1; c < j+2; c++) {
                        if(r >= 0 && r < m && c >= 0 && c < n){
                            sum += img[r][c];
                            count++;
                        }
                    }
                }

                ans[i][j] = sum / count;
            }
        }

        return ans;
    }
}