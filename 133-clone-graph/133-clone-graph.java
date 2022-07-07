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

class Solution {
    public Node cloneGraph(Node node) {
        if ( node == null )
            return null;
        
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Node> map = new HashMap<>();
        
        Node newStart = new Node(node.val, new ArrayList<Node>());
        map.put(node, newStart);
        
        queue.add(node);
        
        while(queue.size() > 0) {
            Node existing = queue.poll();
            Node newNode = map.get(existing);
            
            for(int i=0; existing.neighbors != null && i<existing.neighbors.size(); i++) {
                
                Node curr = existing.neighbors.get(i);
                if ( map.get(curr) == null ) {
                    Node neighbor = new Node(curr.val, new ArrayList<Node>());
                    map.put(curr, neighbor);
                    queue.add(curr);
                }
                
                newNode.neighbors.add(map.get(curr));
            }
        }
        
        return newStart;
    }
}