class Solution {
    
    private int calculateDistance(List<Integer> list) {
        int start = 0;
        int end = list.size() - 1;
        int distance = 0;
        
        while(start < end) {
            distance += list.get(end) - list.get(start);    
            start++;
            end--;
        }
        
        return distance;
    }
    
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        
        for(int i=0; i < grid.length; i++) {
            for(int j=0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    rows.add(i);
            }
        }
        
        for(int i=0; i < grid[0].length; i++) {
            for(int j=0; j < grid.length; j++) {
                if (grid[j][i] == 1)
                    cols.add(i);
            }
        }
        
        return calculateDistance(rows) + calculateDistance(cols);
    }
}