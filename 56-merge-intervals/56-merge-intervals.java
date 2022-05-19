class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int start = intervals[0][0], end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            if ( end < intervals[i][0] ) {
                result.add(new int[]{ start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
            else {
                end = Math.max(end, intervals[i][1]);
            }
        }
        
        result.add(new int[]{ start, end});
        
        int[][] output = new int[result.size()][2];
        int index = 0;
        for( int[] elem: result ) {
            output[index] = result.get(index);
            index++;
        }
        return output;
    }
}
 