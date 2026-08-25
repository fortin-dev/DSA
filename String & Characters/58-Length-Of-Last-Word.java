/*
    58. Length of Last Word
    Easy
    Topics - String
    Given a string s consisting of words and spaces, return the length of the last word in the string.
    A word is a maximal substring consisting of non-space characters only.
*/
// Scanning entire String and updating length based on '_' found
class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int i = 0;
        int res = 0;
        while (i < n) {
            int len = 0;
            int j = i;
            if (Character.isWhitespace(s.charAt(i))) {
                i++;
            } else {
                while (i < n && !Character.isWhitespace(s.charAt(i))) {
                    len++;
                    i++;
                }
                res = len;
            }
        }
        return res;
    }
}

// More optimise, scanning in reverse order, only calculating length of last word
class Solution {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;        
    }
}