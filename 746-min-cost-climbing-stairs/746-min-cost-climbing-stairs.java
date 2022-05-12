class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 1) {
            return cost[0];
        }
        else if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        else {
            int first = cost[0], second = cost[1];
            for(int i = 2; i < cost.length; i++) {
                int temp = Math.min(first, second);
                first = second;
                second = temp + cost[i];
            }
            
            return Math.min(first, second);
        }
    }
}