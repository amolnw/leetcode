class Solution {
    
    class Element{
        int priceTillNow;
        int vertex;
        int stopsLeft;
        
        public Element(int priceTillNow, int vertex, int stopsLeft){
            this.priceTillNow = priceTillNow;
            this.vertex = vertex;
            this.stopsLeft = stopsLeft;
        }
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
        for(int[] flight: flights) {
            HashMap<Integer, Integer> existing = graph.getOrDefault(flight[0], new HashMap<>());
            existing.put(flight[1], flight[2]);
            graph.put(flight[0], existing);
        }
        
        PriorityQueue<Element> queue = new PriorityQueue<>((a,b) -> a.priceTillNow - b.priceTillNow);
        queue.add(new Element(0, src, k + 1));
        
        HashMap<Integer, Integer> visited = new HashMap<>();
        
        while(!queue.isEmpty()) {
            Element current = queue.poll();
            
            if (visited.containsKey(current.vertex) && visited.get(current.vertex) > current.stopsLeft) {
                continue;
            }
            
            visited.put(current.vertex, current.stopsLeft);
            
            if ( current.vertex == dst ) {
                return current.priceTillNow;
            }
            
            if ( current.stopsLeft > 0 ) {
                for(Map.Entry<Integer, Integer> entry: graph.getOrDefault(current.vertex, new HashMap<>()).entrySet()) {
                    queue.add(new Element(current.priceTillNow + entry.getValue(), entry.getKey(), current.stopsLeft - 1));
                }
            }
        }
        
        return -1;
    }
}