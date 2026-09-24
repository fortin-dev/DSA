/*
    695. Max Area of Island
    Medium
    Topics
    premium lock icon
    Companies
    You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
    The area of an island is the number of cells with a value 1 in the island.
    Return the maximum area of an island in grid. If there is no island, return 0.
*/

// Using DFS : O(m*n)tc & sc

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < grid[0].length; n++) {
                if (grid[m][n] == 1) {
                    area = Math.max(area, dfs(m, n, grid));
                }
            }
        }
        return area;
    }
    private int dfs(int m, int n, int[][] grid) {
        if (m < 0 || n < 0 || m >= grid.length || n >= grid[0].length || grid[m][n] == 0) {
            return 0;
        }
        grid[m][n] = 0;
        int res = 1;
        res += dfs(m + 1, n, grid);
        res += dfs(m, n + 1, grid);
        res += dfs(m - 1, n, grid);
        res += dfs(m, n - 1, grid);
        return res;
    }
}
