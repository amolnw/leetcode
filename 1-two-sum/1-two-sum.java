class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> elements = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if ( elements.containsKey(nums[i]) ) {
                return new int[]{ i, elements.get(nums[i]) };
            }
            else {
                elements.put(target - nums[i], i);
            }
        }
        
        return new int[]{-1,-1};
    }
}