class Solution {
    public Node construct(int[][] grid) {
        // Top left: rows from 0 < mid , cols from 0 < mid 
        // Top right: rows from 0 < mid, cols from mid < cols 
        // Bottom left: rows from mid < rows, cols from 0 < mid
        // Bottom right: rows from mid < rows, cols from mid < cols

        return helper(grid, 0, 0,grid.length);

    }

    // top left columns 0 to 2, rows 0 to 2
    // top right columns 2 to 4, rows 0 to 2
    // bottom left coloumns 0 to 2, rows 2 to 4
    // bottom right columns 2 to 4, rows 2 to 4
    // 2 = mid

    private Node helper(int[][] grid,int r, int c,int length){
        int mid = length/2;
        if(sameValue(grid,r,c,length))
            // grid[r][c] == 1 -> true:1 false:0 
            return new Node(grid[r][c] == 1,true); //leaf node
        else{
            Node root = new Node(false,false);
            root.topLeft = helper(grid, r, c, mid);
            root.topRight = helper(grid, r, c+mid, mid);
            root.bottomLeft = helper(grid, r+mid, c, mid);
            root.bottomRight = helper(grid, r+mid, c+mid, mid);
            return root;
        }
    }

    private boolean sameValue(int[][] grid,int x,int y,int length){
        for(int i=x;i<x+length;i++){
            for (int j = y; j < y+length; j++) {
                // if grid section has a different element than the first element return false
                if(grid[i][j] != grid[x][y]) return false;
            }
        }

        return true;
    }
}