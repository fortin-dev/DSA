/*
    211. Design Add and Search Words Data Structure
    Medium
    Topics
    Companies
    Hint
    Design a data structure that supports adding new words and finding if a string matches any previously added string.

    Implement the WordDictionary class:

    WordDictionary() Initializes the object.
    void addWord(word) Adds word to the data structure, it can be matched later.
    bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
*/

// Using Trie : DFS (for checking all children of a node of '.' found in word)
// O(n)tc for addWord() & O(n)for search() with O(t+n)sc : n:length of the string and t is no. of trieNode created
class TrieNode{
    TrieNode[] children;
    boolean word;

    TrieNode(){
        children = new TrieNode[26];
        word = false;
    }
}
class WordDictionary {
    TrieNode root ;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(cur.children[c-'a'] == null){
                cur.children[c-'a'] = new TrieNode();
            }
            cur = cur.children[c-'a'];
        }
        cur.word = true;
    }

    public boolean search(String word) {
        return dfs(word , 0 , root);
    }
    private boolean dfs(String word , int j , TrieNode root){
        TrieNode cur = root;
        for(int i = j; i< word.length(); i++){
            char c = word.charAt(i);
            if(c == '.'){
                for(TrieNode child : cur.children){
                    if(child != null && dfs(word, i+1 , child)){
                        return true;
                    }
                }
                return false;
            }else{
                if(cur.children[c-'a'] == null){
                    return false;
                }
                cur = cur.children[c-'a'];
            }
        }
        return cur.word;
    }
}
