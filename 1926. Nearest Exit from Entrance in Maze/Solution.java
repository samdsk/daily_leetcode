import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        int sr = entrance[0]; // start row
        int sc = entrance[1]; // start col

        Queue<int[]> queue = new LinkedList<>();

        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        queue.offer(new int[]{sr,sc,0}); // row col distance

        maze[sr][sc] = '+'; // mark as visited

        while(!queue.isEmpty()){
            int[] cell = queue.poll();

            int distance = cell[2];

            for(int[] direction : directions){

                int r = cell[0]+direction[0];
                int c = cell[1]+direction[1];

                // System.out.println("Cell: "+r+" "+c);

                if(r<0||r>=m||c<0||c>=n||maze[r][c] == '+') continue;

                maze[r][c] = '+';

                if(isExit(r, c, m, n)){
                    // System.out.println("Found exit: "+r+" "+c);
                    return ++distance;
                }

                queue.offer(new int[]{r,c,distance+1});
            }
        }

        return -1;
    }

    private boolean isExit(int r,int c,int m,int n){
        if(r==m-1 || c == n-1 || r == 0 || c == 0) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nearestExit(new char[][]{{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}}, new int[]{1,2}));
        System.out.println(new Solution().nearestExit(new char[][]{{'.','+','+','+','.','.','.','+','+'},{'.','.','+','.','+','.','+','+','.'},{'.','.','+','.','.','.','.','.','.'},{'.','+','.','.','+','+','.','+','.'},{'.','.','.','.','.','.','.','+','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','+','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','+'},{'+','.','.','.','+','.','.','.','.'}}, new int[]{1,2}));
    }
}