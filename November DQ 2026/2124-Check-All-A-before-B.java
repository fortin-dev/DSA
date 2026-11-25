/*
    2124. Check if All A's Appears Before All B's
    Solved
    Easy
    Topics
    premium lock icon
    Companies
    Hint
    Given a string s consisting of only the characters 'a' and 'b', return true if every 'a' appears before every 'b' in the string. Otherwise, return false.
*/
// Simple solution : O(n)tc
class Solution {
    public boolean checkString(String s) {
        for(int i = 1 ; i < s.length() ; i++){
            if(s.charAt(i-1)-'a' > s.charAt(i)-'a'){
                return false;
            }
        }
        return true;
    }
}