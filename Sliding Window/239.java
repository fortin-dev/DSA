// O(n)tc using Deque
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length ; 
        int [] res = new int [n - k + 1];
        Deque<Integer> q = new LinkedList<>();
        int l =0 , r=0;
        
        while(r < n){
            while(!q.isEmpty() && nums[q.getLast()] < nums[r]){
                q.removeLast();
            }
            q.addLast(r);

            if(l > q.getFirst()){
                q.removeFirst();
            }
            
            if((r+1) >= k){
                res[l]= nums[q.getFirst()];
                l++;
            }
            r++;
        }
        return res;
    }
}
//  dynamic programming approach O(n)tc
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = nums[0];
        rightMax[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            if (i % k == 0) {
                leftMax[i] = nums[i];
            } else {
                leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
            }

            if ((n - 1 - i) % k == 0) {
                rightMax[n - 1 - i] = nums[n - 1 - i];
            } else {
                rightMax[n - 1 - i] = Math.max(rightMax[n - i], nums[n - 1 - i]);
            }
        }
        int[] res = new int[n - k + 1];
        for (int i = 0; i < (n - k + 1); i++) {
            res[i] = Math.max(leftMax[i + k - 1], rightMax[i]);
        }
        return res;
    }
}