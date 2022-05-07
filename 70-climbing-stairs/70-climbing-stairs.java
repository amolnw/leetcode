/*
1 - 1
2 - 2
3 - 1,1,1 1,2 2,1 - 3
4 - 1,1,1,1 1,2,1 2,1,1 1,2,2 2,2    
*/
class Solution {
    public int climbStairs(int n) {
        int first = 1, second = 2, result = 0;
        if ( n == 1 ) 
            return first;
        else if ( n == 2 )
            return second;
        else {
            for(int i = 3; i <= n; i++) {
                result = first + second;
                first = second;
                second = result;
            }
        }
        
        return result;
    }
}