class Solution {
    public int climbStairs(int n) {
        int f = 1, s = 2;
        if ( n == 1 )
            return f;
        else if ( n == 2 )
            return s;
        else {
            for(int i = 3; i <= n; i++) {
                int temp = s;
                s = temp + f;
                f = temp;
            }
        }
        
        return s;
    }
}