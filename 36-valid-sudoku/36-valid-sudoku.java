class Solution {
    
    List<HashSet<Character>> rows;
    List<HashSet<Character>> cols;
    List<HashSet<Character>> boxes;
    
    public Solution() {
        rows = new ArrayList<>();
        cols = new ArrayList<>();
        boxes = new ArrayList<>();
    }
    
    private void init(int r, int c) {
        for(int i = 0; i < r; i++) {
            rows.add(new HashSet<Character>());
            boxes.add(new HashSet<Character>());
        }  
        
        for(int i = 0; i < c; i++) {
            cols.add(new HashSet<Character>());
        }  
    }
    
    public boolean isValidSudoku(char[][] board) {
        init(board.length, board[0].length);
        
        for(int i = 0; i < board.length; i++) {
            for(int j=0; j < board[0].length; j++) {
                if ( board[i][j] == '.' )
                    continue;
                
                int b = (i/3 * 3) + j/3;
                if ( rows.get(i).contains(board[i][j]) || cols.get(j).contains(board[i][j]) || boxes.get(b).contains(board[i][j])) {
                    return false;
                }
                
                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);
                boxes.get(b).add(board[i][j]);
            }
        }
        
        return true;
    }
}