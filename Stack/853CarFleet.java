// O(nlogn)tc with O(n)sc using stack
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();
        for (int[] p : pair) {
            stack.push((double) (target - p[0]) / p[1]);
            if (stack.size()>=2 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop();
            }
        }
        return stack.size();
    }
}
//O(target)tc with O(n)sc - better approach than using stack
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int fleets =0;
        float[] time = new float[target+1];
        for(int i =0; i<speed.length;i++){
            time[position[i]] = (float)( target - position[i] )/ speed[i];
        }
       float prev = time[target];
        for(int i =target-1;i>=0;i--){
            if(time[i] > prev){
                fleets++;
                 prev = time[i];
            }
           
        }
        return fleets;
    }
}