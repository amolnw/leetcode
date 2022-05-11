class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == ')' && stack.empty()) || (s.charAt(i) == ']' && stack.empty()) || (s.charAt(i) == '}' && stack.empty())) {
                return false;
            }
            else if ((s.charAt(i) == ')' && stack.peek() == '(') || (s.charAt(i) == ']' && stack.peek() == '[') || (s.charAt(i) == '}' && stack.peek() == '{')) {
                stack.pop();
            }
            else if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                return false;
            } 
            else {
                stack.push(s.charAt(i));
            }
        }
        
        return stack.size() == 0 ? true : false;
    }
}
