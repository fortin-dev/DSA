/*
    208. Implement Trie (Prefix Tree)
    Solved
    Medium
    Topics
    Companies
    A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

    Implement the Trie class:

    Trie() Initializes the trie object.
    void insert(String word) Inserts the string word into the trie.
    boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
    boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 
*/
// Using array : Prefix tree with two properite an array of size 26 for its children and a boolean to mark end of word

//O(n)tc & O(t)sc where n is length of string & t is no. of tries created
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}
class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            int i = c-'a';
            if(cur.children[i] == null){
                cur.children[i] = new TrieNode();
            }
            cur = cur.children[i];
        }
        cur.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            int i = c-'a';
            if(cur.children[i] == null) return false;
            cur = cur.children[i];
        }
        return cur.isEnd ;
        
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char c : prefix.toCharArray()){
            int i = c-'a';
            if(cur.children[i] == null) return false;
            cur = cur.children[i];
        }
        return true;
    }
}
