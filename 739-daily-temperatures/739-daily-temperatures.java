class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int i = temperatures.length - 1; i >= 0; i--) {
            while ( !stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()] ) {
                stack.pop();
            }
            
            if ( stack.isEmpty() ) {
                result[i] = 0;
            }
            else {
                result[i] = stack.peek() - i;
            }
            
            stack.push(i);
        }
        
        return result;
    }
}

//[89,62,70,58,47,47,46,76,100,70]
//[8,  1, 5, 4, 1, 2, 1, 1,  0, 0]
//[8,  1, 5, 4, 3, 2, 1, 1,  0, 0]