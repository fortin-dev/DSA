//------my logic ---------
// class Solution {
//     public int trap(int[] height) {
//         int i = 0;
//         int water = 0;
//         int len = height.length;
//         if(len<=2){
//             return 0;
//         }
//         while (height[i] == 0 && i < len) {
//             i += 1;
//         }
//         if (i == len) {
//             return 0;
//         }
//         int j = 0;
//         while (i < len - 2 || j < len) {
//             j = (i + 1);
//             while ((j < len) && (height[i] > height[j])) {
//                 j += 1;
//             }
//             if (j >= len) {
//                 i += 1;
//                 continue;
//             }
//             if (height[i] <= height[j] && i + 1 == j) {
//                 i = j;
//                 continue;
//             }
//             // else if(height[i]<=height[j]){
//             if (height[i] <= height[j]) {
//                 int k = i + 1;
//                 while (k < j) {
//                     water += height[i] - height[k];
//                     k++;
//                 }
//                 i = j;
//             }
//         }

//         return water;
//     }
// }

//-------O(n)tc & o(n)sc
class Solution {
    public int trap(int[] height) {
        if(height == null || height.length==0){
            return 0;
        }
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        maxLeft[0]=0;
        maxRight[n-1]=0;
        int currMax ;
        for(int i= 1; i<n; i++){
            currMax=Math.max(maxLeft[i-1],height[i-1]);
            maxLeft[i]=currMax;
        }
        for(int i= n-2; i>=0; i--){
            currMax=Math.max(maxRight[i+1],height[i+1]);
            maxRight[i]=currMax;
        }
        int res= 0;
        for(int i =0; i< n ; i++){
            int min = Math.min(maxLeft[i], maxRight[i]); 
            res+=Math.max(0,min-height[i]);
        }
        return res;
    }
}

//best approach - O(n)tc & O(1)sc

class Solution {
    public int trap(int[] height) {
        if(height == null || height.length==0){
            return 0;
        }
        int l=0;
        int r = height.length -1;
        int leftMax = height[l];
        int rightMax = height[r];
        int max=0;
        while(l<r){
            if(leftMax < rightMax){
                l++;
                leftMax= Math.max(leftMax, height[l]);
                max+=leftMax - height[l];
            }
            else{
                r--;
                rightMax = Math.max(rightMax, height[r]);
                max+= rightMax - height[r];
            }
        }
        return max;
    }
}

