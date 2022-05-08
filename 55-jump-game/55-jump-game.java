class Solution {
    public boolean canJump(int[] nums) {
        int lastReachablePosition = nums.length - 1;
        
        for(int i = nums.length - 1; i >= 0; i--) {
            if ( i + nums[i] >= lastReachablePosition ) 
                lastReachablePosition = i;
        }
        
        return lastReachablePosition == 0;
    }
}