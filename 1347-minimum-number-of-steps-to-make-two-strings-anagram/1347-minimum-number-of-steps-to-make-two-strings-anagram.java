class Solution {
    public int minSteps(String s, String t) {
        int[] charCount = new int[26];
        for(char c: s.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        for(char c: t.toCharArray()) {
            if (charCount[c - 'a'] > 0)
                charCount[c - 'a']--;
        }
        
        int minimumSteps = 0;
        for(int i = 0; i < 26; i++) {
            minimumSteps += charCount[i];
        }
        
        return minimumSteps;
    }
}