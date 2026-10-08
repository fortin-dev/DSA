/* 
    743. Network Delay Time
    Medium
    You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

    We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
*/
// Using DSF : we try all possible track from 'k'and keep track of minimum time for each node
// O(V*E)tc & O(V+E)sc where V is no. of vertices and E is no. of edges
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

// Using Dijkstra's Algorithm : O(E log V)tc & O(V+E)sc where V is no. of vertices and E is no. of edges
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[]{v, w});
        }

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int)1e9);

        dist[k] = 0;
        pq.offer(new int[]{0, k});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();
            int dis = curr[0];
            int node = curr[1];

            if (dis > dist[node]) continue;

            for (int[] it : adj.get(node)) {

                int adjNode = it[0];
                int wt = it[1];

                if (dis + wt < dist[adjNode]) {

                    dist[adjNode] = dis + wt;
                    pq.offer(new int[]{dist[adjNode], adjNode});
                }
            }
        }

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == (int)1e9) return -1;
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}
