class Solution {
    Map<Integer, HashSet<Integer>> graph = new HashMap<>();
    
    public int minTrioDegree(int n, int[][] edges) {
        for( int[] edge: edges ){
            int s = edge[0];
            int d = edge[1];
            
            HashSet<Integer> e0 = graph.getOrDefault(s, new HashSet<Integer>());
            e0.add(d);
            graph.put(s, e0);
            
            HashSet<Integer> e1 = graph.getOrDefault(d, new HashSet<Integer>());
            e1.add(s);
            graph.put(d, e1);
        }    
        
        int result = Integer.MAX_VALUE;
        for( int[] edge: edges ) {
            int s = edge[0];
            int d = edge[1];
            
            HashSet<Integer> e1 = graph.get(s);
            HashSet<Integer> e2 = graph.get(d);
            
            for(int num: e1) {
                if ( e2.contains(num) ) {
                    result = Math.min(result, e1.size() + e2.size() + graph.get(num).size() - 6);
                }
            }
        }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
}