class DetectSquares {

    Map<Integer, Map<Integer, Integer>> points;
    public DetectSquares() {
        points = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        Map<Integer, Integer> yAndCountMap = points.getOrDefault(x, new HashMap<>());
        yAndCountMap.put(y, yAndCountMap.getOrDefault(y, 0) + 1);
        points.put(x, yAndCountMap);
    }
    
    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int result = 0;
        
        for( Map.Entry<Integer, Map<Integer, Integer>> xEntry: points.entrySet()) {
            int currX = xEntry.getKey();
            for(Map.Entry<Integer, Integer> yEntry: xEntry.getValue().entrySet()) {
                int currY = yEntry.getKey();
                if ( Math.abs( x - currX ) == 0 || Math.abs( x - currX ) !=  Math.abs( y - currY ) ) {
                    continue;
                }
                //Need to find currX, y && x, currY
                if ( !points.get(currX).containsKey(y) || !points.containsKey(x) || !points.get(x).containsKey(currY) ) {
                    continue;
                }
                
                result += (points.get(currX).get(y) * points.get(x).get(currY) * points.get(currX).get(currY));
            }
        }
        
        return result;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
    

      