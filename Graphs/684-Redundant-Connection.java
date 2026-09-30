/*
    684. Redundant Connection
    Medium
    In this problem, a tree is an undirected graph that is connected and has no cycles.

    You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

    Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.
*/

// Using Disjoint Set Union : O(V+E*(a(E)))tc & O(V)sc
public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] par = new int[edges.length + 1];
        int[] rank = new int[edges.length + 1];
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            if (!union(par, rank, edge[0], edge[1]))
                return new int[]{edge[0], edge[1]};
        }
        return new int[0];
    }

    private int find(int[] par, int n) {
        int p = par[n];
        while (p != par[p]) {
            par[p] = par[par[p]];
            p = par[p];
        }
        return p;
    }

    private boolean union(int[] par, int[] rank, int n1, int n2) {
        int p1 = find(par, n1);
        int p2 = find(par, n2);

        if (p1 == p2)
            return false;
        if (rank[p1] > rank[p2]) {
            par[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            par[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}

// using DFS : cycle detection and returning the edge[] when that cylce is detected 
// O(E*(V+E))tc & O(V+E)sc
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);

            boolean[] visit =  new boolean[n + 1];

            if (dfs(u, -1, adj, visit)) {
                return edge;
            }
        }
        return new int[0];
    }
    private boolean dfs(int node, int parent, List<List<Integer>> adj, boolean[] visit) {
        if (visit[node]) {
            return true;
        }
        visit[node] = true;
        ;
        for (int nei : adj.get(node)) {
            if (nei == parent) {
                continue;
            }
            if (dfs(nei, node, adj, visit)) {
                return true;
            }
        }
        return false;
    }
}

// Using Optimised DFS : we use a visit set and cycleStart pointer to mark the start of the cycle
// O(V+E)tc & sc
class Solution {
    private boolean[] visit;
    private List<List<Integer>> adj;
    private Set<Integer> cycle;
    private int cycleStart;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        visit = new boolean[n+1];
        cycle = new HashSet<>();
        cycleStart = -1;
        dfs(1,-1);
        for(int i = edges.length-1 ; i>= 0 ;i--){
            int u = edges[i][0] , v = edges[i][1];
            if(cycle.contains(u) && cycle.contains(v)){
                return new int[]{u,v};
            }
        }
        return new int[0];
    }
    private boolean dfs(int node , int par){
        if(visit[node]){
            cycleStart = node;
            return true;
        }
        visit[node] = true;
        for(int nei : adj.get(node)){
            if (nei == par) continue;
            if(dfs(nei , node)){
                if(cycleStart != -1) cycle.add(node);
                if(node == cycleStart){
                    cycleStart = -1;
                }
                return true;
            }
        }
        return false;
    }
}
