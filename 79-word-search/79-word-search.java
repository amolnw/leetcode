class Solution {
    
    private boolean dfs(char[][] board, String word, int index, int row, int col, boolean[][] visited) {
        
        // Do this first as second check will fail when checking word char At
        if ( index == word.length() )
            return true;
        
        if ( row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || word.charAt(index) != board[row][col] )
            return false;
        
        visited[row][col] = true;
        
        if ( dfs(board, word, index + 1, row+1, col, visited) || dfs(board, word, index + 1, row-1, col, visited) || dfs(board, word, index + 1, row, col+1, visited) || dfs(board, word, index + 1, row, col-1, visited) ) {
            return true;
        }
        
        visited[row][col] = false;
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if ( board[i][j] == word.charAt(0) && !visited[i][j] ) {
                    if ( dfs(board, word, 0, i, j, visited) ) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}