class Solution {
    public int shortestDistance(int[][] grid) {
        int[][] dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        int[][] distance = new int[grid.length][grid[0].length];
        
        int result = Integer.MAX_VALUE;
        int checkValue = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    int level = 1;
                    result = Integer.MAX_VALUE;
                    
                    while(!queue.isEmpty()) {
                        int queueSize = queue.size();
                        for(int k = 0; k < queueSize; k++) {
                            
                            int[] current = queue.poll();
                            for(int[] dir: dirs) {
                                int newRow = dir[0] + current[0];
                                int newCol = dir[1] + current[1];
                                
                                if ( newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == checkValue ) {
                                    grid[newRow][newCol]--;
                                    queue.add(new int[]{newRow, newCol});
                                    distance[newRow][newCol] += level;
                                    result = Math.min(result, distance[newRow][newCol]);
                                }
                            }
                            
                        }
                        
                        level++;
                    }
                    
                    checkValue--;
                }
            }
        }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
