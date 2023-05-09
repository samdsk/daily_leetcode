import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length-1;
        int cols = matrix[0].length-1;
        int r = 0;
        int c = 0;

        List<Integer> ans = new LinkedList<>();

        while(r<=rows && c<=cols){
            for(int i = c;i<=cols;i++){
                ans.add(matrix[r][i]);
            }
            r++;

            for(int i = r;i<=rows;i++){
                ans.add(matrix[i][cols]);
            }
            cols--;

            if(r<=rows){
                for(int i = cols;i>=c;i--){
                    ans.add(matrix[rows][i]);
                }
            }
            rows--;

            if(c<=cols){
                for(int i = rows;i>=r;i--){
                    ans.add(matrix[i][c]);
                }
            }
            c++;
        }

        return ans;
    }
}