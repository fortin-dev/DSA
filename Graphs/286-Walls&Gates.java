/*
    -- This is a primium problem , so the below description is same but with different term, logic is same 
    Islands and Treasure
    Medium
    Topics
    You are given a m×n ,m×n 2D grid initialized with these three possible values:
    -1 - A water cell that can not be traversed.
    0 - A treasure chest.
    INF - A land cell that can be traversed. We use the integer 2^31 - 1 = 2147483647 to represent INF.
    Fill each land cell with the distance to its nearest treasure chest. If a land cell cannot reach a treasure chest then the value should remain INF.
    Assume the grid can only be traversed up, down, left, or right.
    Modify the grid in-place.
    Example 1:
    Input: [
    [2147483647,-1,0,2147483647],
    [2147483647,2147483647,2147483647,-1],
    [2147483647,-1,2147483647,-1],
    [0,-1,2147483647,2147483647]
    ]
    Output: [
    [3,-1,0,1],
    [2,2,1,-1],
    [1,-1,2,-1],
    [0,-1,3,4]
]
*/

// Multi source BFS : instead of starting from infinity cells, we start from the treasure cell itself, this was our most repearted work become less
// O(m*n)tc & sc Where m is the number of rows and n is the number of columns in the grid
public class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[] { i, j });
                }
            }
        }
        if (q.size() == 0) return;

        int[][] dirs = { { -1, 0 }, { 0, -1 },
                         { 1, 0 }, { 0, 1 } };
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];
            for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r >= m || c >= n || r < 0 ||
                    c < 0 || grid[r][c] != Integer.MAX_VALUE) {
                    continue;
                }
                q.add(new int[] { r, c });

                grid[r][c] = grid[row][col] + 1;
            }
        }
    }
}