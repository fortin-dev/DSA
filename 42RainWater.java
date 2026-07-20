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
//