class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        char[] letters = word.toCharArray();
        int[][] visited = new int[m][n];

        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                if(find(board,letters,0,r,c, visited))
                    return true;
            }
        }

        return false;
    }
    private boolean find(char[][] board, char[] letters, int index, int r, int c, int[][] visited){
        if(index == letters.length) return true;
        if(r < 0 || r >= board.length) return false 
        if(c < 0 || c >= board[0].length) return false; 
        if(visited[r][c] == 1 || letters[index] != board[r][c]) return false;

        visited[r][c] = 1;
        boolean res =   find(board, letters, index+1, r-1, c, visited) ||
                        find(board, letters, index+1, r, c+1, visited) ||
                        find(board, letters, index+1, r+1, c, visited) ||
                        find(board, letters, index+1, r, c-1, visited);
        visited[r][c] = 0;
        return res;

    }
}