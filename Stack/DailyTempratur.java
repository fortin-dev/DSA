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

//O(n)tc using stack with o(n)sc(exept result array)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int l = temperatures.length ;
        int[] r = new int[l];
        Stack<int[]> st = new Stack<>();
        for(int i =0; i<l ;i++){
            int t = temperatures[i];
            while(!st.isEmpty() && t > st.peek()[0]){
                int[] pair = st.pop();
                r[pair[1]] = i - pair[1];
            }
            st.push(new int[]{t,i});
        }
        return r;
    }
}

// best approach O(n)tc with O(1)sc(exept result array) using Dynamic programming
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int l = temperatures.length;
        int[] res = new int[l];
        for(int i = l-2; i>=0 ; i--){
            int j = i+1;
            while(j<l && temperatures[j]<=temperatures[i]){
                if(res[j]==0){
                    j=l;
                    break;
                }
                j+=res[j];
            }
            if(j<l){
                res[i]=j-i;
            }
        }
        return res;
    }
}