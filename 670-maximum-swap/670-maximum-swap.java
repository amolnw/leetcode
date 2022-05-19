class Solution {
    public int maximumSwap(int num) {
        char[] numChar = Integer.toString(num).toCharArray();
        
        int[] pos = new int[10];
        for(int i = 0; i < numChar.length; i++) {
            pos[numChar[i] - '0'] = i;
        }
        
        for(int i = 0; i < numChar.length; i++) {
            for(int j = 9; j > numChar[i] - '0'; j--) {
                if ( pos[j] > i ) {
                    char temp = numChar[i];
                    numChar[i] = numChar[pos[j]];
                    numChar[pos[j]] = temp;
                    
                    return Integer.valueOf(String.valueOf(numChar));
                }
            }
        }
        
        return num;
    }
}