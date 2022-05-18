class Solution {
    
    private boolean isAlphaNumeric(char c) {
        return Character.isAlphabetic(c) || Character.isDigit(c);
    }
    
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        
        while(start < end) {
            if ( isAlphaNumeric(s.charAt(start)) && isAlphaNumeric(s.charAt(end)) ) {
                if ( Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end)) ) {
                    return false;
                }
                else {
                    start++;
                    end--;
                }
            }
            else if ( !isAlphaNumeric(s.charAt(start)) ) {
                start++;
            }
            else if ( !isAlphaNumeric(s.charAt(end)) ) {
                end--;
            }
        }
        
        return true;
    }
}