/*
    1046. Last Stone Weight
    Solved
    Easy
    Topics
    premium lock icon
    Companies
    Hint
    You are given an array of integers stones where stones[i] is the weight of the ith stone.

    We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:

    If x == y, both stones are destroyed, and
    If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
    At the end of the game, there is at most one stone left.

    Return the weight of the last remaining stone. If there are no stones left, return 0.
*/
// Using PriorityQueue : 
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone: stones) maxHeap.offer(stone);

        while(maxHeap.size()>1){
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            int res = smash(x,y);
            if(res!=0)maxHeap.offer(res);
        }

        return maxHeap.size()==0? 0 : maxHeap.poll();
        
    }

    private int smash(int x, int y){
        if(x==y)return 0;
        return x>y? x-y : y-x;
    }
}
