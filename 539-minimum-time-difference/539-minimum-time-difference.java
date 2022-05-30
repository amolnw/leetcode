class Solution {
    public int findMinDifference(List<String> timePoints) {
        int numberOfMins = 24 * 60;
        boolean[] timeArray = new boolean[numberOfMins];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(String str: timePoints) {
            int timeVal = Integer.parseInt(str.substring(0,2)) * 60 + Integer.parseInt(str.substring(3));
            if ( timeArray[timeVal] ) {
                return 0;
            }
            
            timeArray[timeVal] = true;
            min = Math.min(min, timeVal);
            max = Math.max(max, timeVal);
        }
        
        //1440 - max + min is for handling circular case like 00:00 and 23:59
        //which should return 1
        int result = Math.min(max - min, 1440 - max + min), prev = min;
        for(int i = min + 1; i <= max; i++) {
            if ( timeArray[i] ) {
                result = Math.min(result, i - prev);
                prev = i;
            }
        }
        
        return result;
    }
}