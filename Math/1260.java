class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        k %= total;

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> r = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                r.add(0);
            }
            res.add(r);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int newVal = ((i * n + j) + k) % total;
                int newR = newVal / n;
                int newC = newVal % n;
                res.get(newR).set(newC, grid[i][j]);
            }
        }
        return res;
    }
}