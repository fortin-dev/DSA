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
// Using BFS : O(m*n)tc & sc
class Solution {
    private static final int[][] directions = { { 1, 0 }, { -1, 0 },
            { 0, 1 }, { 0, -1 } };

    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    area = Math.max(area, bfs(r, c, grid));
                }
            }
        }
        return area;
    }

    private int bfs(int r, int c, int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { r, c });
        grid[r][c] = 0;
        int res = 1;
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0], col = node[1];

            for (int[] dir : directions) {
                int nr = row + dir[0], nc = col + dir[1];
                if (nr >= 0 && nc >= 0 && nr < grid.length &&
                        nc < grid[0].length && grid[nr][nc] == 1) {
                    q.add(new int[] { nr, nc });
                    grid[nr][nc] = 0;
                    res++;
                }
            }
        }
        return res;
    }
}