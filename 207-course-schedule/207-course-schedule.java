class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int i=0; i<numCourses; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }
        
        for(int[] prerequisite: prerequisites) {
            int parent = prerequisite[0];
            int child = prerequisite[1];
            
            inDegree.put(child, inDegree.get(child)+1);
            graph.get(parent).add(child);
        }
        
        Queue<Integer> sources = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry: inDegree.entrySet()) {
            if ( entry.getValue() == 0 ) {
                sources.add(entry.getKey());
            }
        }
        
        while(!sources.isEmpty()) {
            int source = sources.poll();
            sortedOrder.add(source);
            List<Integer> children = graph.get(source);
            
            for(int child: children) {
                inDegree.put(child, inDegree.get(child)-1);
                if(inDegree.get(child) == 0) {
                    sources.add(child);
                }
            }
        }
        
        if ( sortedOrder.size() == numCourses ) 
            return true;
        
        return false;
    }
}