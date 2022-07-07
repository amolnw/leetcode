class Solution {
    
    int find(int[] graph, int key) {
        if( graph[key] == -1 ){
            return key;
        }
        return find(graph, graph[key]);
    }
    
    boolean union(int[] graph, int i, int j) {
        
        int x = find(graph, i);
        int y = find(graph, j);
        
        if ( x == y )
            return false;
        
        graph[x] = y;
        return true;
    }
    
    public boolean validTree(int n, int[][] edges) {
        int[] graph = new int[n];
        
        for(int i=0; i<n; i++) {
            graph[i] = -1;
        }
        
        for(int i=0;i<edges.length;i++) {
            if ( !union(graph, edges[i][0], edges[i][1]) )
                return false;
        }
        
        int count =0;
        for(int i=0; i<n; i++) {
            if (graph[i] == -1)
                count++;
        }
        return count > 1 ? false: true ;
    }
}