import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Data> queue = new PriorityQueue<>();

        for (int i = 0; i < mat.length; i++) {
            int soldiers = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j]==1) soldiers++;
            }

            queue.offer(new Data(i,soldiers));
        }

        
        int[] ans = new int[k];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = queue.poll().row;
        }

        return ans;
    }

    record Data(int row, int soldiers) implements Comparable<Data>{
        @Override public int compareTo(Data o){
            if(soldiers == o.soldiers)
                return Integer.compare(row,o.row);
            else
                return Integer.compare(soldiers,o.soldiers);
        }
    }
}