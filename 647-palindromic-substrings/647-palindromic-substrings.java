class Solution {
    
    private int expandAroundCenter(String s, int left, int right) {
        int result = 0;
        while( left >= 0 && right < s.length() ) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            
            left--;
            right++;
            result++;
        }
        
        return result;
    }
    
    public int countSubstrings(String s) {
        int result = 0;
        
        for(int i = 0; i < s.length(); i++) {
            result += expandAroundCenter(s, i, i);
            result += expandAroundCenter(s, i, i+1);
        }
        return result;
        
    }
}

