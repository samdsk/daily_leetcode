import java.util.Arrays;

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;
        int[] xs = new int[n];

        for (int i = 0; i < n; i++) {
            xs[i] = points[i][0];
        }

        Arrays.sort(xs);
        
        int x1 = xs[0];
        int max = 0;

        for (int i = 1; i < n; i++) {
            int x2 = xs[i];
            int temp = x2 - x1;

            if(temp > max)
                max = temp;

            x1 = x2;
        }

        return max;
    }
}

// [[7,4],[8,7],[9,7],[9,9]]

// [[1,0],[1,4],[3,1],[5,3],[8,8],[9,0]]