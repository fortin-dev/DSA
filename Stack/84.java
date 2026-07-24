// O(n)tc*sc using stack
class Solution {
    public int largestRectangleArea(int[] heights) {
        int l = heights.length;
        Stack<int[]> stack = new Stack<>();
        int maxarea = 0;
        for(int i = 0; i<l ; i++){
            int start = i;
            int h = heights[i];
            while(!stack.isEmpty() && stack.peek()[1] > h){
                int[] top = stack.pop();
                int idx = top[0];
                int currH= top[1];
                maxarea = Math.max(maxarea, currH *(i - idx));
                start = idx;
            }
            stack.push(new int[]{start, h});
        }

        for(int[] pair: stack){
            int i = pair[0];
            int h = pair[1];
            maxarea = Math.max(maxarea, (h * (l-i)));
        }
        return maxarea;
    }
}

// more optimal aproach -- finds result in one pass

class Solution {
    public int largestRectangleArea(int[] heights) {
        int l = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxarea = 0;
        for(int i = 0; i<=l ; i++){
            while(!stack.isEmpty() && 
            (i==l || heights[stack.peek()] >= heights[i])){
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek()-1 ;
                maxarea = Math.max(maxarea, h*w);
            }
            stack.push(i);
        }
        return maxarea;
    }
}
