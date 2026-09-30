/*
    Number of Connected Components in an Undirected Graph
    Medium
    Topics
    You have an undirected graph of n nodes labeled from 0 to n - 1. You are given an integer n and an array edges where edges[i] = [aᵢ, bᵢ] indicates that there is an edge between aᵢ and bᵢ in the graph.

    Return the number of connected components in the graph.
*/

// Using DFS : we create a boolean visit array, we run dfs on every node while marking the node visited in that path in the visit array, if elements left in visit array we continue doing the dfs , evertime visit array is check and dfs is called it mean new component is found , hence we increase it .
public class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int res = 0;
        for (int node = 0; node < n; node++) {
            if (!visit[node]) {
                dfs(adj, visit, node);
                res++;
            }
        }
        return res;
    }

    private void dfs(List<List<Integer>> adj, boolean[] visit, int node) {
        visit[node] = true;
        for (int nei : adj.get(node)) {
            if (!visit[nei]) {
                dfs(adj, visit, nei);
            }
        }
    }
}

// Using BFS
class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visit = new boolean[n];
        for(int i =0; i<n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int res =0; 
        for(int node =0 ; node < n ; node++){
            if(!visit[node]){
                bfs(adj , visit, node);
                res++;
            }
        }
        return res;
    }
    private void bfs(List<List<Integer>> adj , boolean[] visit , int node){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visit[node] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int nei : adj.get(cur)){
                if(!visit[nei]){
                    visit[nei] = true;
                    q.offer(nei);
                }
            }
        }
    }
}

// Using DSU : Disjoint Set Union : RANK | SIZE
// O(V+ E*(a(V)))tc where V is no. of vertices and E is no. edges and 'a' is amortized complexity : almost constant
class DSU {
    int[] parent;
    int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int node) {
        int cur = node;
        while (cur != parent[cur]) {
            parent[cur] = parent[parent[cur]];
            cur = parent[cur];
        }
        return cur;
    }

    public boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv) {
            return false;
        }
        if (rank[pv] > rank[pu]) {
            int temp = pu;
            pu = pv;
            pv = temp;
        }
        parent[pv] = pu;
        rank[pu] += rank[pv];
        return true;
    }
}

public class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int res = n;
        for (int[] edge : edges) {
            if (dsu.union(edge[0], edge[1])) {
                res--;
            }
        }
        return res;
    }
}