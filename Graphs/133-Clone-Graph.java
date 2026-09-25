/*
    133. Clone Graph
    Medium
    Topics
    Companies
    Given a reference of a node in a connected undirected graph.
    Return a deep copy (clone) of the graph.
    Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
*/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

// Using DFS + HashMap : why use hashmap: because graphs contains cycles , unlike tree : if we use simple dfs like used in tree , then the recursion will stuck in an cycle i.e infinite loop , so to tackel this we are using hasmap : when we see a new node we craete a copy , when we see same node again , we reuse the already created copy of the node 
// O(V+E)tc & O(V)sc where V no. is vertices and E no. of edges
class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> nodeMap = new HashMap<>();

        return dfs(node, nodeMap);
    }
    private Node dfs(Node node, Map<Node, Node> nodeMap) {
        if (node == null) {
            return null;
        }

        if (nodeMap.containsKey(node)) {
            return nodeMap.get(node);
        }

        Node copy = new Node(node.val);
        nodeMap.put(node, copy);

        for (Node n : node.neighbors) {
            copy.neighbors.add(dfs(n, nodeMap));
        }

        return copy;
    }
}

// Using BFS : Queue -> O(V+E)tc & O(V)sc where V no. is vertices and E no. of edges
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null ) return null;
        Map<Node, Node> nodeMap = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        nodeMap.put(node, new Node(node.val));
        q.add(node);

        while(!q.isEmpty()){
            Node cur = q.poll();
            for(Node n : cur.neighbors){
                if(!nodeMap.containsKey(n)){
                    nodeMap.put(n , new Node(n.val));
                    q.add(n);
                }
                nodeMap.get(cur).neighbors.add(nodeMap.get(n));
            }
        }
        return nodeMap.get(node);
    }
}