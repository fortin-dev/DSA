/*
    130. Surrounded Regions
    Medium
    Topics
    Companies- Meta/Facebook
    You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

    Connect: A cell is connected to adjacent cells horizontally or vertically.
    Region: To form a region connect every 'O' cell.
    Surround: A region is surrounded if none of the 'O' cells in that region are on the edge of the board. Such regions are completely enclosed by 'X' cells.
    To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.
*/

// Using DFS : instead of checking every cell, we first mark the cells that are not surrounded , ie border cell, then we mark all the remaining 'O'cell : which 'are' surrounded, to 'X' and border cellls and their neighbors which were not surrounded back to 'O';
// O(m*n)tc & sc
class Solution {
    public void solve(char[][] board) {
        int ROWS = board.length, COLS = board[0].length;
        for (int r = 0; r < ROWS; r++) {
            if (board[r][0] == 'O') {
                dfs(board, r, 0);
            }
            if (board[r][COLS - 1] == 'O') {
                dfs(board, r, COLS - 1);
            }
        }

        for (int c = 0; c < COLS; c++) {
            if (board[0][c] == 'O') {
                dfs(board, 0, c);
            }
            if (board[ROWS - 1][c] == 'O') {
                dfs(board, ROWS - 1, c);
            }
        }
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }
    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'T';
        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}
// Using BFS : Queuem=, same approach but using BFS :  O(m*n)tc & sc
class Solution {
    private int ROWS, COLS;
    private int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;

        bfs(board);
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }
    private void bfs(char[][] board) {
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (r == 0 || r == ROWS - 1 || c == 0 || c == COLS - 1 && board[r][c] == 'O') {
                    q.offer(new int[] {r, c});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];
            if (board[r][c] == 'O') {
                board[r][c] = 'T';
                for (int[] dir : directions) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS) {
                        q.offer(new int[] {nr, nc});
                    }
                }
            }
        }
    }
}
