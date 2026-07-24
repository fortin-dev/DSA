class Solution {
    public int scoreOfString(String s) {
        char[] schar = s.toCharArray();
        int sum=0;
        int len = schar.length;
        for(int i =1 ; i < len; i++){
            sum+= Math.abs(schar[i-1] - schar[i]);
        }
        return sum;
    }
}

//more optimised
class Solution {
    public int scoreOfString(String s) {
        int sum =0;
        for(int i =1; i<s.length(); i++){
            sum+= Math.abs(s.charAt(i-1)-s.charAt(i));
        }
        return sum;
    }
}