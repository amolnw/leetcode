class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }
        
        int longest = 0;
        
        for(int i = 0; i < nums.length; i++) { 
            if ( !hashSet.contains(nums[i] - 1) ) {
                int start = nums[i];
                int current = 0;
                
                while(hashSet.contains(start)) {
                    current++;
                    start++;
                }
                
                longest = Math.max(longest, current);
            }
        }
        
        return longest;
    }
}