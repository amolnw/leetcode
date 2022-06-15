class Solution {
    
    class TrieNode{
        String word;
        TrieNode[] children = new TrieNode[26];
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word: words) {
            TrieNode current = root;
            for(char ch: word.toCharArray()) {
                int childIndex = ch - 'a';
                if ( current.children[childIndex] == null )
                    current.children[childIndex] = new TrieNode();
                current = current.children[childIndex];
            }
            current.word = word;
        }
        return root;
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        char ch = board[i][j];
        
        if ( board[i][j] == '#' || node.children[ch - 'a'] == null )
            return;
        
        node = node.children[ch - 'a'];
        if ( node.word != null ){
            result.add(node.word);
            node.word = null;
        }
        
        board[i][j] = '#';
        
        if ( i > 0 ) 
            dfs(board, i-1, j, node, result);
        
        if ( j > 0 ) 
            dfs(board, i, j-1, node, result);
        
        if ( i < board.length - 1 ) 
            dfs(board, i+1, j, node, result);
        
        if ( j < board[0].length - 1 ) 
            dfs(board, i, j+1, node, result);
        
        board[i][j] = ch;    
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }
}