//brute force approach - O(n^2)tc
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length == 1) {
            return new int[] {0};
        }
        int l = temperatures.length;
        int[] r = new int[l];
        for (int i = 0; i < l - 1; i++) {
            int j = i + 1 ;
            while (j < l && temperatures[j] <= temperatures[i]) {
                j++;
            }
            if(j!=l){
                r[i]= j-i;
            }
            else{
                r[i]=0;
            }
        }
        return r;
    }
}
