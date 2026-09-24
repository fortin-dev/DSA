/*
    Number of Islands
    Medium
    Topics
    Company Tags
    Given a 2D grid grid where '1' represents land and '0' represents water, count and return the number of islands.

    An island is formed by connecting adjacent lands horizontally or vertically and is surrounded by water. You may assume water is surrounding the grid (i.e., all the edges are water).
*/

// Using DFS : O(m*n)tc & sc
class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < grid[0].length; n++) {
                if (grid[m][n] == '1') {
                    dfs(m, n, grid);
                    res++;
                }
            }
        }
        return res;
    }
    private void dfs(int m, int n, char[][] grid) {
        if (m < 0 || n < 0 || m >= grid.length || n >= grid[0].length || grid[m][n] == '0') {
            return;
        }
        grid[m][n] = '0';
        dfs(m+1,n, grid);
        dfs(m,n+1, grid);
        dfs(m-1,n, grid);
        dfs(m,n-1, grid);
    }
}

// Using BFS : Queue O(m*n)tc & sc
public class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0},
                                               {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int islands = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '1') {
                    bfs(grid, r, c);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void bfs(char[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        grid[r][c] = '0';
        q.add(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0], col = node[1];

            for (int[] dir : directions) {
                int nr = row + dir[0], nc = col + dir[1];
                if (nr >= 0 && nc >= 0 && nr < grid.length &&
                    nc < grid[0].length && grid[nr][nc] == '1') {
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = '0';
                }
            }
        }
    }
}