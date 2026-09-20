/*
    Word Search II
    Hard
    Topics
    Company Tags
    Hints
    Given a 2-D grid of characters board and a list of strings words, return all words that are present in the grid.
    For a word to be present it must be possible to form the word with a path in the board with horizontally or vertically neighboring cells. The same cell may not be used more than once in a word.
    Example 1:
    Input:
    board = [
    ["a","b","c","d"],
    ["s","a","a","t"],
    ["a","c","k","e"],
    ["a","c","d","n"]
    ],
    words = ["bat","cat","back","backend","stack"]
    Output: ["cat","back","backend"]
*/
/*
    Using backtracking : Trie + HashSet : build the trie for all the words and then run dfs on board while marking the visited cell

    O(m*n*4*3^t-1 +s)tc & O(s)sc
    where m : no. of rows, 
        n : no. of columns, 
        t : is the maximum length of any word in the array words words
        s : is sum of lengths of all the words
*/
class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;

    public TrieNode(){
        children = new HashMap<>();
        isWord = false;
    }
    public void addWord(String word){
        TrieNode cur = this;
        for(char c: word.toCharArray()){
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }
}
class Solution {
    private Set<String> res;
    private boolean[][] visit;
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words){
            root.addWord(word);
        }

        int ROWS = board.length , COLS = board[0].length;
        res = new HashSet<>();
        visit = new boolean[ROWS][COLS];

        for(int r = 0 ; r<ROWS ; r++){
            for(int c = 0; c < COLS ; c++){
                dfs(board, r, c, root , "");
            }
        }
        return new ArrayList<>(res);
    }
    private void dfs(char[][] board, int r , int c, TrieNode node , String word){
        int ROWS = board.length , COLS  = board[0].length;
        if(r<0 | c<0 || r>=ROWS || c>=COLS || visit[r][c] || !node.children.containsKey(board[r][c])){
            return;
        }
        visit[r][c] = true;
        node = node.children.get(board[r][c]);
        word += board[r][c];
        if(node.isWord){
            res.add(word);
        }

        dfs(board, r+1, c , node , word);
        dfs(board, r-1, c , node , word);
        dfs(board, r, c+1 , node , word);
        dfs(board, r, c-1 , node , word);
        visit[r][c] = false;
    }
}
