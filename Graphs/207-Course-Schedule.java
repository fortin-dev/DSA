/*
    207. Course Schedule
    Medium
    Topics
    Companies
    Hint
    There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
    Return true if you can finish all courses. Otherwise, return false.
*/

// Using DFS : first we create an adjency list of every node to represent the prerequisitis required , and for every prerequisite we run dfs and add it to our visited set , if some node is already at set and we try to insert it -> it mean cycle existed and course cannot be finished 

// O(V+E)tc & sc where V-> no. of courses and E->no. of edges
class Solution {
    private Map<Integer, List<Integer>> preMap = new HashMap<>();
    private Set<Integer> visiting = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            preMap.get(prereq[0]).add(prereq[1]);
        }

        for(int c =0 ; c< numCourses; c++){
            if(!dfs(c)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int crs){
        if(visiting.contains(crs)){
            return false ;
        }
        if(preMap.get(crs).isEmpty()){
            return true;
        }
        visiting.add(crs);
        for(int pre: preMap.get(crs)){
            if(!dfs(pre)){
                return false;
            }
        }
        visiting.remove(crs);
        preMap.put(crs, new ArrayList<>());
        return true;
    }
}
// Using BFS : Kahn's Algorithm
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        while (!q.isEmpty()) {
            int node = q.poll();
            finish++;
            for (int nei : adj.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        return finish == numCourses;
    }
}