class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int i = 0;
        int j = s.length()-1;
        while(i<=j){
            if(isAlphaNum(s.charAt(i)) && isAlphaNum(s.charAt(j))){
                if(s.charAt(i)==s.charAt(j)){
                    i++;
                    j--;
                }
                else{
                    return false;
                }
            }
            else{
                if(!isAlphaNum(s.charAt(i))){
                    i++;
                }
                if(!isAlphaNum(s.charAt(j))){
                    j--;
                }
            }
        }
        return true;
    }
    public static boolean isAlphaNum(char c){
        return (c>=97 && c<=122) || (c>=48 && c<=57);
    }
}