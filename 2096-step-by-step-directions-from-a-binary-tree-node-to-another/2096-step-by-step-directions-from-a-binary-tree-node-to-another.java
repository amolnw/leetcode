/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private boolean dfs(TreeNode node, int val, StringBuilder sb){
        if ( node == null ) {
            return false;
        }
        if ( node.val == val ) {
            return true;
        }
        
        boolean left = dfs(node.left, val, sb.append("L"));
        if (!left) {
            sb.deleteCharAt(sb.length()-1);
        }
        boolean right = dfs(node.right, val, sb.append("R"));
        if (!right) {
            sb.deleteCharAt(sb.length()-1);
        }
        return left || right;
    }
    
    public String getDirections(TreeNode root, int startValue, int endValue) {
        StringBuilder left = new StringBuilder(), right = new StringBuilder();
        dfs(root, startValue, left);
        dfs(root, endValue, right);
        int i = 0;
        for(; i < Math.min(left.length(), right.length()); i++) {
            if ( left.charAt(i) != right.charAt(i) ) {
                break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < left.length() - i; j++ ){
            sb.append("U");
        }
        
        sb.append(right.substring(i));
        return sb.toString();
    }
}