class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> invalidIndexes = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            if ( s.charAt(i) == '(' ) {
                stack.push(i);
            }
            else if ( s.charAt(i) == ')' && !stack.isEmpty() ) {
                stack.pop();
            }
            else if ( s.charAt(i) == ')' ) {
                invalidIndexes.add(i);
            }
        }
        
        while(!stack.isEmpty()) {
            invalidIndexes.add(stack.pop());
        }
        
        for(int i = 0; i < s.length(); i++) {
            if ( !invalidIndexes.contains(i) ) {
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}