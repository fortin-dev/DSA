/*
    3942. Minimum Operations to Sort a Permutation
    Medium
    You are given an integer array nums of length n, where nums is a permutation of the integers from 0 to n - 1.

    You may perform only the following operations:

    Reverse the entire array.
    Rotate Left by One: Move the first element to the end of the array, and rest elements to left by one position.
    Return an integer denoting the minimum number of operations required to sort the array in increasing order. If it is not possible to sort the array using only the given operations, return -1.
*/
// Checking whether array is sorted & rotated :  ascending + descending : O(n)tc 
class Solution {
    public int minOperations(int[] A) {
        int n = A.length;
        int asc = 1, dsc = 1;

        for (int i = 1; i < n; i++) {
            if (A[i] == (A[i - 1] + 1) % n)
                asc++;            
            if (A[i - 1] == (A[i] + 1) % n)
                dsc++;
        }

        if (asc == n)
            return A[0] == 0 ? 0 : Math.min(n - A[0], A[0] + 2);

        if (dsc == n)
            return Math.min(n - A[n - 1], A[n - 1]) + 1;

        return -1;
    }
}
// 2-3ms better
class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        if(n==1)return 0;
        int dec=-1;
        for(int i=1;i<n;i++){
            if(nums[i]!=nums[i-1]+1){
                if(dec!=-1){
                    dec=n+1;
                    break;
                }
                dec=i;
            }
        }
        if(dec==-1)return 0;
        if(dec<n)return Math.min(dec,2+(n-dec));
        int inc=-1;
        for(int i=1;i<n;i++){
            if(nums[i]!=nums[i-1]-1){
                if(inc!=-1){
                    inc=n+1;
                    break;
                }
                inc=i;
            }
        }
        if(inc==-1)return 1;
        if(inc<n){
            return Math.min(inc,n-inc)+1;
        }
        return -1;
    }
}