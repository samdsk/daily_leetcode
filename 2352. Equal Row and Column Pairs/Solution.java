import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;

        Map<String,Integer> map = new HashMap<>();

        for(int[] row : grid){
            String tempRow = Arrays.toString(row);
            map.put(tempRow,map.getOrDefault(tempRow, 0)+1);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int[] row = new int[n];
            for (int j = 0; j < n; j++) {
                row[j] = grid[j][i];
            }
            String tempRow = Arrays.toString(row);
            ans += map.getOrDefault(tempRow,0);
        }

        return ans;
    }
}