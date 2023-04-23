class Solution {
    public int diagonalSum(int[][] mat) {
        int m = mat.length;

        int sum = 0;

        for (int i = 0; i < m; i++) {
            sum += mat[i][i];
            sum += mat[m-i-1][i];
        }

        if(m % 2 != 0) return sum - mat[m/2][m/2];

        return sum;
    }

}