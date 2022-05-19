class Solution {
    public int shortestPath(int[][] grid, int k) {
        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        Integer[][] visited = new Integer[grid.length][grid[0].length];
        
        int level = 0;
        queue.add(new int[]{0, 0, k});
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                
                if ( current[0] == grid.length-1 && current[1] == grid[0].length-1)
                    return level;
                
                for(int[] dir: dirs) {
                    int nR = current[0] + dir[0];
                    int nC = current[1] + dir[1];
                    
                    if ( nR >= 0 && nC >= 0 && nR < grid.length && nC < grid[0].length ) {
                        
                        int obstaclesLeft = grid[nR][nC] == 1 ? current[2] - 1 : current[2];
                        
                        if ( obstaclesLeft >= 0 && ( visited[nR][nC] == null || visited[nR][nC] < obstaclesLeft ) ) {
                            visited[nR][nC] = obstaclesLeft;
                            queue.add(new int[]{nR, nC, obstaclesLeft});
                        }
                    }
                }
            }
            
            level++;
        }
        
        return -1;
    }
}