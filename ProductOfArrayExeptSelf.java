class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        int[] pre = new int[n+1];
        pre[0] = 1;

        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i-1] *nums[i-1];
        }

        int[] post = new int[n+1];
        post[n] = 1;

        for (int i = n-1; i > 0; i--) {
            post[i] = post[i+1]*nums[i];
        }
        
        for(int i = 0 ; i<n; i++){
            res[i]=pre[i]*post[i+1];
        }
        return res;
    }
}
