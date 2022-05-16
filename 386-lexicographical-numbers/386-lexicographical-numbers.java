class Solution {
    private void dfs(int n, int current, List<Integer> result) {
        if ( current > n ) {
            return;
        }
        
        result.add(current);
        
        for(int i = 0; i < 10; i++) { 
            if ( current*10 + i > n )
                continue;
            
            dfs(n, current*10 + i, result);
        }
    } 
    
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i < 10; i++)  
            dfs(n, i, result);
        return result;
    }
}