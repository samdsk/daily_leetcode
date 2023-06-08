class Solution {
    public int countNegatives(int[][] grid) {

        int n = grid[0].length;
        int negs = n-1;

        int count = 0;

        for(int[] row : grid){
            while(negs>=0 && row[negs]<0){
                negs--;
            }

            count += n - (negs + 1);
        }

        return count;
    }
}

/*
 * [4, 3, 2, -1],
 * [3, 2, 1, -1],
 * [1, 1, -1,-2],
 * [-1,-1,-2,-3]
 */