class Solution {
    private int find(int[] graph, int n) {
        if ( graph[n] == n )
            return n;
        return find(graph, graph[n]);
    }
    
    private void union(int[] graph, int a, int b) {
        int aKey = find(graph, a);
        int bKey = find(graph, b);
        
        if ( aKey != bKey )
            graph[aKey] = bKey;
    }
    
    public int countComponents(int n, int[][] edges) {
        int[] graph = new int[n];
        for(int i = 0; i < n; i++) {
            graph[i] = i;
        }
        
        for(int i = 0; i < edges.length; i++) {
            union(graph, edges[i][0], edges[i][1]);
        }
        
        int result = 0;
        for(int i = 0; i < n; i++) {
            if ( graph[i] == i ) 
                result++;
        }
        
        return result;
    }
}