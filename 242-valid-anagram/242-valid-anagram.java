class Solution {
    public boolean isAnagram(String s, String t) {
        
        if ( s.length() != t.length() )
            return false;
        
        int[] map = new int[26];
        
        for(int i = 0; i < s.length(); i++){
            map[s.charAt(i) - 'a']++;
        }
            
        for(int i = 0; i < t.length(); i++){
            if ( map[t.charAt(i) - 'a'] > 0 ) {
                map[t.charAt(i) - 'a']--;
            }
            else {
                return false;
            }
        }
          
        return true;
    }
}