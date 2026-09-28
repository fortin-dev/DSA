/*
    210. Course Schedule II
    Medium
    Topics
    premium lock icon
    Companies
    Hint
    There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
    Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
*/

// Using DFS : we create a prereq map , a cycle set and a visit set, : the cycle set detects any cycles as if store the current path-> if found two prereq twic -> return false immideatlly -> we also store a visite set -> which represent the courses which ae completed  ie they dont need further checking 

// O(V+E)tc & sc : V is no. of course and E is no. of prerequisites
class Solution {
    private Map<Integer, List<Integer>> premap;
    private Set<Integer> cycle;
    private Set<Integer> visit;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        premap = new HashMap<>();
        cycle = new HashSet<>();
        visit = new HashSet<>();
        for(int[] pre : prerequisites){
            premap.computeIfAbsent(pre[0], k-> new ArrayList<>()).add(pre[1]);
        }   
        List<Integer> output = new ArrayList<>();
        for(int crs = 0;  crs < numCourses ; crs++){
            if(!dfs(crs, output)){
                return new int[0];
            }
        }
        int [] res = new int[numCourses];
        for(int i = 0 ; i < numCourses ;i++){
            res[i] = output.get(i);
        }
        return res;
    }
    private boolean dfs(int crs , List<Integer> output){
        if(cycle.contains(crs)){
            return false;
        }
        if(visit.contains(crs)){
            return true;
        }
        cycle.add(crs);
        for(int pre : premap.getOrDefault(crs, Collections.emptyList())){
            if(!dfs(pre, output)){
                return false;
            }
        }
        cycle.remove(crs);
        visit.add(crs);
        output.add(crs);
        return true;
    }
}

// Topological Sort : Kahn's Algorithm : Using BFS
//  O(V+E)tc & sc : V is no. of course and E is no. of prerequisites

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            indegree[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int finish = 0;
        int[] output = new int[numCourses];
        while (!q.isEmpty()) {
            int node = q.poll();
            output[numCourses - finish - 1] = node;
            finish++;
            for (int nei : adj.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        if (finish != numCourses) {
            return new int[0];
        }
        return output;
    }
}