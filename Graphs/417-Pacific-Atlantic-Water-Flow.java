/*
    417. Pacific Atlantic Water Flow
    Medium
    Topics
    Companies
    There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

    The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

    The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

    Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
*/
// Using DFS : instead of checking every cell , we do it in reverse ie we start from ocean and move back into cells , with rules inverted this way we do not have to check each and every cell
// O(m*n)tc & sc 
public class Solution {
    private int[][] directions = {{1, 0}, {-1, 0},
                                  {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        for (int c = 0; c < COLS; c++) {
            dfs(0, c, pac, heights);
            dfs(ROWS - 1, c, atl, heights);
        }
        for (int r = 0; r < ROWS; r++) {
            dfs(r, 0, pac, heights);
            dfs(r, COLS - 1, atl, heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pac[r][c] && atl[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, boolean[][] ocean, int[][] heights) {
        ocean[r][c] = true;
        for (int[] d : directions) {
            int nr = r + d[0], nc = c + d[1];
            if (nr >= 0 && nr < heights.length &&
                nc >= 0 && nc < heights[0].length &&
                !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                dfs(nr, nc, ocean, heights);
            }
        }
    }
}

// Using BFS : Queue - O(m*n)tc & sc
public class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        Queue<int[]> pacQueue = new LinkedList<>();
        Queue<int[]> atlQueue = new LinkedList<>();

        for (int c = 0; c < COLS; c++) {
            pacQueue.add(new int[]{0, c});
            atlQueue.add(new int[]{ROWS - 1, c});
        }
        for (int r = 0; r < ROWS; r++) {
            pacQueue.add(new int[]{r, 0});
            atlQueue.add(new int[]{r, COLS - 1});
        }

        bfs(pacQueue, pac, heights);
        bfs(atlQueue, atl, heights);

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pac[r][c] && atl[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    private void bfs(Queue<int[]> q, boolean[][] ocean, int[][] heights) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            ocean[r][c] = true;
            for (int[] d : directions) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < heights.length && nc >= 0 &&
                    nc < heights[0].length && !ocean[nr][nc] &&
                    heights[nr][nc] >= heights[r][c]) {
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
}