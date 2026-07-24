//O(nlogn-O(1))
class Solution {
    public int[] replaceElements(int[] arr) {
        if(arr==null) return arr;
        if(arr.length ==1) return new int[]{-1};

        int n = arr.length;
        int[] ans = new int[n];
        for(int i = 0 ; i<n-1 ; i++){
            // ans[i]= arr[i];
            for(int j = i+1; j<n ; j++){
                if(ans[i]<=arr[j]){
                    ans[i]=arr[j];
                }
            }
        }
        ans[n-1]=-1;
        return ans;
    }
}
//more optimized code - O(n)-O(1)
class Solution {
    public int[] replaceElements(int[] arr) {
        int[] ans = new int[arr.length];
        int mx= -1;
        for(int i = arr.length-1 ; i>=0; i--){
            ans[i]=mx;
            mx=Math.max(mx,arr[i]);
        }
        return ans;
    }
}