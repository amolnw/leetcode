class Solution {
    
    private double dfs(HashMap<String, HashMap<String, Double>> graph, HashSet<String> visited, String src, String dest) {
        if ( src.equals(dest) ) {
            return 1.0;
        }
        
        if ( visited.contains(src) ) {
            return 0.0;
        }
        
        visited.add(src);
        
        HashMap<String, Double> children = graph.get(src);
        for(Map.Entry<String, Double> entry: children.entrySet()) {
            double output = dfs(graph, visited, entry.getKey(), dest);
            if ( output != 0 ) {
                return output * entry.getValue();
            }
        }
        
        visited.remove(src);
        return 0;
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        
        for(int i = 0; i < equations.size(); i++) {
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            
            HashMap<String, Double> child = graph.getOrDefault(src, new HashMap<>());
            child.put(dest, values[i]);
            graph.put(src, child);
            
            child = graph.getOrDefault(dest, new HashMap<>());
            child.put(src, 1/values[i]);
            graph.put(dest, child);
        }
        
        double[] result = new double[queries.size()];
        
        for(int i = 0; i < queries.size(); i++) {
            if ( !graph.containsKey(queries.get(i).get(0)) || !graph.containsKey(queries.get(i).get(1)) ) {
                result[i] = -1;
            }
            else if (queries.get(i).get(0).equals(queries.get(i).get(1))) {
                result[i] = 1;
            }
            else {
                double output = dfs(graph, new HashSet<String>(), queries.get(i).get(0), queries.get(i).get(1));
                result[i] = output == 0 ? -1 : output;
            }
        }
        
        return result;
    }
}