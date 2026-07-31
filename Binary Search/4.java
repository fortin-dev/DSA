// 4. Median of Two Sorted Arrays
// Hard
// Topics - Mid Level, Array, Binary Search, Divide and Conquer
// Companies - Meta

// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

// The overall run time complexity should be O(log (m+n)).

 

// Example 1:

// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.
// Example 2:

// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] A = nums1;
        int [] B = nums2;
        int total = A.length + B.length ;
        int half = (total+1)/2;

        if(B.length < A.length){
            int[] temp = A;
            A = B;
            B = temp;
        }
        int l =0;
        int r = A.length;

        while(l<=r){
            int i = (l+r)/2;
            int j = half - i;

            int Aleft = i > 0 ? A[i-1] : Integer.MIN_VALUE;
            int Aright = i < A.length ? A[i] : Integer.MAX_VALUE;
            int Bleft = j > 0 ? B[j-1] : Integer.MIN_VALUE;
            int Bright = j< B.length ? B[j] : Integer.MAX_VALUE;

            if(Aleft <= Bright && Bleft <= Aright){
                if(total %2 !=0){
                    return Math.max(Aleft, Bleft);
                }
                return (Math.max(Aleft , Bleft) + Math.min(Aright, Bright)) / 2.0;
            }
            else if (Aleft > Bright){
                r = i-1;
            }else{
                l = i+1;
            }
        }
        return -1;
    }
}