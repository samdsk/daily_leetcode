import java.util.Arrays;

class Solution {
    private class UnionFind {
        int[] root, size;

        public UnionFind(int n) {
            root = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
            size = new int[n];
            Arrays.fill(size, 1);
        }

        public int find(int x) {
            if (root[x] != x) {
                root[x] = find(root[x]);
            }
            return root[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            if (size[rootX] > size[rootY]) {
                int tmp = rootX;
                rootX = rootY;
                rootY = tmp;
            }
            root[rootX] = rootY;
            size[rootY] += size[rootX];
        }
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        UnionFind dsu = new UnionFind(row * col + 2);
        int[][] grid = new int[row][col];
        int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        for (int i = 0; i < row*col; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            grid[r][c] = 1;
            int index1 = r * col + c + 1;

            for(int[] direction : moves){
                int newR = r + direction[0];
                int newC = c + direction[1];

                int index2 = newR * col + newC + 1;
                if(newR >= 0 && newR<row && newC >= 0 && newC<col && grid[newR][newC] == 1){
                    dsu.union(index1, index2);
                }
            }

            if( c == 0) dsu.union(0, index1);
            if(c == col -1) dsu.union(row*col + 1, index1);

            if(dsu.find(0) == dsu.find(row*col+1)) return i;

        }

        return -1;
    }
}