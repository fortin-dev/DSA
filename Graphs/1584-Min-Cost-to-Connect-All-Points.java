/*
    1584. Min Cost to Connect All Points
    Medium
    You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

    The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

    Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
*/
// Minimum Spanning Tree : using Prim's Algorithm
// O(n^2 log n)tc & O(n^2)sc
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int N = points.length;
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int i =0 ; i<N; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j = i+1; j<N; j++){
                int x2= points[j][0];
                int y2= points[j][1];
                int dist = Math.abs(x1-x2) + Math.abs(y1-y2);
                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{dist, j});
                adj.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[]{dist, i});
            }
        }
        int res = 0;
        Set<Integer> visit = new HashSet<>();
        PriorityQueue<int[]> minH = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        minH.offer(new int[]{0,0});
        while(visit.size() < N){
            int[] curr = minH.poll();
            int cost = curr[0];
            int i = curr[1];
            if(visit.contains(i)){
                continue;
            }
            res+=cost;
            visit.add(i);
            for(int [] nei : adj.getOrDefault(i, Collections.emptyList())){
                int neiCost = nei[0];
                int neiIndex = nei[1];
                if(!visit.contains(neiIndex)){
                    minH.offer(new int[]{neiCost, neiIndex});
                }
            }
        }
        return res;
    }
}
