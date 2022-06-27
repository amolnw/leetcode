class StockPrice {
    private int latestTime;
    private HashMap<Integer, Integer> priceForTime;
    private PriorityQueue<int[]> minQueue, maxQueue;

    public StockPrice() {
        latestTime = 0;    
        priceForTime = new HashMap<>();
        minQueue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        maxQueue = new PriorityQueue<>((a,b) -> b[1] - a[1]);
    }
    
    public void update(int timestamp, int price) {
        latestTime = Math.max(latestTime, timestamp);
        priceForTime.put(timestamp, price);
        minQueue.add(new int[]{timestamp, price});
        maxQueue.add(new int[]{timestamp, price});
    }
    
    public int current() {
        return priceForTime.get(latestTime);
    }
    
    public int maximum() {
        while(!maxQueue.isEmpty() && priceForTime.get(maxQueue.peek()[0]) != maxQueue.peek()[1]) {
            maxQueue.poll();
        }
        return maxQueue.peek()[1];
    }
    
    public int minimum() {
        while(!minQueue.isEmpty() && priceForTime.get(minQueue.peek()[0]) != minQueue.peek()[1]) {
            minQueue.poll();
        }
        return minQueue.peek()[1];
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */