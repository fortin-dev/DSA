/*
    3963. Create Grid With Exactly One Path
    Easy
    You are given two integers m and n, representing the number of rows and columns of a grid.

    Construct any m x n grid consisting only of the characters '.' and '#', where:

    '.' represents a free cell.
    '#' represents an obstacle cell.
    A valid path is a sequence of free cells that:

    Starts at the top-left cell (0, 0).
    Ends at the bottom-right cell (m - 1, n - 1).
    Moves only:
    Right, from (i, j) to (i, j + 1), or
    Down, from (i, j) to (i + 1, j).
    Return any grid such that there is exactly one valid path from the top-left cell to the bottom-right cell.
*/

// Simple Stair Case Solution : fill->change O()
class Solution {
    public String[] createGrid(int m, int n) {
        char[][] charRes = new char[m][n];
        int i =0,j=0;
        for(i =0 ; i <m ; i++){
            for(j =0; j<n ; j++){
                charRes[i][j]='#';
            }
        }
        i=0;
        j=0;
        charRes[0][0]='.';
        while(i<m && j<n){
            if(i<m && j+1<n){
                charRes[i][++j] = '.';
            }
            if(i+1<m && j<n){
                charRes[++i][j]='.';
            }
            if(i==m-1 && j==n-1){
                break;
            }
        }
        String[] res = new String[m];
        for(i = 0 ; i<m ; i++){
            res[i] = new String(charRes[i]);
        }
        return res;
    }
}
//Optimzed solution using array.fill()
class Solution {
    public String[] createGrid(int m, int n) {
        char[][] charRes = new char[m][n];
        int i =0,j=0;
        for (i = 0; i < m; i++) {
            Arrays.fill(charRes[i], '#');
        }
        i=0;
        charRes[0][0]='.';
        while(i<m && j<n){
            if(i<m && j+1<n){
                charRes[i][++j] = '.';
            }
            if(i+1<m && j<n){
                charRes[++i][j]='.';
            }
            if(i==m-1 && j==n-1){
                break;
            }
        }
        String[] res = new String[m];
        for(i = 0 ; i<m ; i++){
            res[i] = new String(charRes[i]);
        }
        return res;
    }
}