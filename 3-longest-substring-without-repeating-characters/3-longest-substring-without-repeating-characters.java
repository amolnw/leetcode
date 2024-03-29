class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0, start = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            /*
            charMap.get(s.charAt(i)) >= start) is important for cases like abba
            */
            if ( charMap.containsKey(s.charAt(i) ) && charMap.get(s.charAt(i)) >= start) {
                result = Math.max(i - start, result);
                start = charMap.get(s.charAt(i)) + 1;
            }
            charMap.put(s.charAt(i), i);    
        }
        
        /*
        This is important for handling last case
        */
        return Math.max(s.length() - start, result);
    }
}
