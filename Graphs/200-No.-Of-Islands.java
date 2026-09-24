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
