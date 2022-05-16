class Solution {
    int closest;
    
    private void recursive(int[] toppingCosts, int tIndex, int target, int current) {
        
        if ( Math.abs(target - current) < Math.abs(target - closest) || 
            ( Math.abs(target - current) == Math.abs(target - closest) && current < closest ) ) {
            closest = current;
        } 
        
        if ( current > target || tIndex == toppingCosts.length ) {
            return;
        }
        
        recursive(toppingCosts, tIndex+1, target, current);
        recursive(toppingCosts, tIndex+1, target, current + toppingCosts[tIndex]);
        recursive(toppingCosts, tIndex+1, target, current + toppingCosts[tIndex] + toppingCosts[tIndex]);
        
    }
    
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        closest = baseCosts[0];
        for(int i = 0; i< baseCosts.length; i++) {
            recursive(toppingCosts, 0, target, baseCosts[i]);
        }
        return closest;
    }
}