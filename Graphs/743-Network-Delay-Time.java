/* 
    743. Network Delay Time
    Medium
    You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

    We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
*/
// Using DSF : we try all possible track from 'k'and keep track of minimum time for each node
// O(V*E)tc & O(V+E)sc wher V is no. of vertices and E is no. of edges
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int[] time: times){
            adj.computeIfAbsent(time[0], 
            x-> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        Map<Integer, Integer> dist = new HashMap<>();
        for(int i = 1; i<=n ; i++) dist.put(i, Integer.MAX_VALUE);

        dfs(k, 0, adj, dist);
        int res = Collections.max(dist.values());
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void dfs(int node, int time, Map<Integer, List<int[]>> adj, Map<Integer, Integer> dist){
        if(time >= dist.get(node)) return;
        dist.put(node ,time);
        if(!adj.containsKey(node)) return;
        for(int[] edge : adj.get(node)){
            dfs(edge[0], time+edge[1], adj, dist);
        }
    }
}
