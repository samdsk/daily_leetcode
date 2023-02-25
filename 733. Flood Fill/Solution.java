/**
 * Solution
 */
public class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldcolor = image[sr][sc];
        if(color != oldcolor) colorize(image, sr, sc, oldcolor, color);
        return image;
    }

    public void colorize(int[][] image, int row,int col,int oldcolor,int color){
        if(image[row][col] == oldcolor) {
            image[row][col] = color;
            if(row >= 1) colorize(image, row-1, col, oldcolor, color);
            if(col >= 1) colorize(image, row, col-1, oldcolor, color);
            if(row+1 < image.length) colorize(image, row+1, col, oldcolor, color);
            if(col+1 < image[0].length) colorize(image, row, col+1, oldcolor, color);
        }
    }

    public static void main(String[] args) {
        int[][] image = new Solution().floodFill(new int[][] {{0,0,0},{0,0,0}}, 1, 0, 2);

        for(int[] x : image){
            for(int j : x)
                System.out.print(j+",");
            System.out.println();

        }
    }
}