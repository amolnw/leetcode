class Solution {
    public int compress(char[] chars) {
        int idx = 0;
        int newLength = 0;
        
        while(idx < chars.length){
            char current = chars[idx];
            int count = 0;
            
            while(idx < chars.length && chars[idx] == current) {
                idx++;
                count++;
            }
            
            chars[newLength++] = current;
            
            if ( count > 1 ) {
                char[] countArray = Integer.toString(count).toCharArray();
                for(char c: countArray) {
                    chars[newLength++] = c;
                }
            }
        }
        
        return newLength;
    }
}