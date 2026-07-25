class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for(int i = 0; i<s1.length() ;i++){
            arr1[s1.charAt(i)-'a']++;
            arr2[s2.charAt(i)-'a']++;
        }
        int match=0;
        for(int i = 0; i<26 ; i++){
            if(arr1[i] == arr2[i]){
                match++;
            }
        }
        int l=0;
        for(int r=s1.length() ; r<s2.length() ; r++){
            if(match==26){
                return true;
            }
            int idx = s2.charAt(r)-'a';
            arr2[idx]++;
            if(arr1[idx]==arr2[idx]){
                match++;
            }
            else if(arr1[idx]+1 == arr2[idx]){
                match--;
            }

            idx = s2.charAt(l)-'a';
            arr2[idx]--;
            if(arr1[idx] == arr2[idx]){
                match++;
            }
            else if(arr1[idx]-1 == arr2[idx]){
                match--;
            }
            l++;
        }
        return match==26;
    }
}