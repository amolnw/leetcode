class Solution {
    
    private boolean[][] bfs(int[][] heights, Queue<int[]> queue) {
        boolean[][] result = new boolean[heights.length][heights[0].length];
        int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1} };
        while(!queue.isEmpty()) {
            int[] cell = queue.poll(); 
            result[cell[0]][cell[1]] = true;
            
            for(int[] dir: dirs) {
                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[1];
                
                if ( newRow >=0 && newRow < heights.length && newCol >= 0 && newCol < heights[0].length && !result[newRow][newCol] && heights[cell[0]][cell[1]] <= heights[newRow][newCol]) {
                    queue.offer(new int[]{ newRow, newCol });
                }
            }
        }
        
        return result;
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        Queue<int[]> pacific = new LinkedList<>();
        Queue<int[]> atlantic = new LinkedList<>();
        
        for(int i = 0; i < heights.length; i++) {
            pacific.offer(new int[]{i,0});
            atlantic.offer(new int[]{i,heights[0].length-1});
        }
        
        for(int i = 0; i < heights[0].length; i++) {
            pacific.offer(new int[]{0, i});
            atlantic.offer(new int[]{heights.length-1, i});
        }
        
        boolean[][] pacificReachable = bfs(heights, pacific);
        boolean[][] atlanticReachable = bfs(heights, atlantic);
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0; i < heights.length; i++) {
            for(int j = 0; j < heights[0].length; j++) {
                if ( pacificReachable[i][j] && atlanticReachable[i][j] ) {
                    result.add(List.of(i, j));
                }
            }
        }
        
        return result;
    }
}