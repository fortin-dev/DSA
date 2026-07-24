//O(m*n)tc and O(m)sc using  sliding window technique
class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        for(char c: s.toCharArray()){
            set.add(c);
        }
        for(char c : set){
            int  count=0, l=0;
            for(int r = 0; r<s.length(); r++ ){
                if(s.charAt(r)==c){
                    count++;
                }
                while((r-l+1) - count > k){
                    if(s.charAt(l)==c){
                        count--;
                    }
                    l++;
                }
                max = Math.max(max, r-l+1);
            }
        }
        return max;
    }
}

//more optimal appraoch of sliding window

class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int l = 0, maxf = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, map.get(s.charAt(r)));
            while ((r - l + 1) - maxf > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
