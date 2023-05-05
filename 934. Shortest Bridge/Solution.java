import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<int[]> bfsQueue;

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int firstX = -1, firstY = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    firstX = i;
                    firstY = j;
                    break;
                }
            }
        }

        bfsQueue = new ArrayList<>();
        dfs(grid, firstX, firstY, n);

        int distance = 0;

        while(!bfsQueue.isEmpty()){
            List<int[]> newBfs = new ArrayList<>();

            for (int[] pair : bfsQueue) {
                int x = pair[0], y = pair[1];
                for (int[] nextPair : new int[][]{{x + 1, y}, {x - 1, y}, {x, y + 1}, {x, y - 1}}) {
                    int curX = nextPair[0], curY = nextPair[1];

                    if(0<=curX && curX < n && 0 <= curY && curY < n){
                        if(grid[curX][curY] == 1) return distance;
                        else if(grid[curX][curY] == 0){
                            newBfs.add(nextPair);
                            grid[curX][curY] = -1;
                        }
                    }
                }
            }
            bfsQueue = newBfs;
            distance++;
        }

        return distance;

    }

    private void dfs(int[][] grid, int x,int y, int n){
        grid[x][y] = 2;
        bfsQueue.add(new int[]{x,y});

        for(int[] pair : new int[][]{{x + 1, y}, {x - 1, y}, {x, y + 1}, {x, y - 1}}){
            int curX = pair[0], curY = pair[1];

            if(0<=curX && curX < n && 0 <= curY && curY < n && grid[curX][curY] == 1){
                dfs(grid,curX,curY,n);
            }
        }
    }

}