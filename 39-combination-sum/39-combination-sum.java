class Solution {
    
    private void cSum(List<List<Integer>> result, List<Integer> current, int[] candidates, int target, int index) {
        if ( target < 0 ) {
            return;
        }
        
        if ( target == 0 ) {
            result.add(new ArrayList<>(current));    
        }
        
        for(int i = index; i < candidates.length; i++) {
            current.add(candidates[i]);
            cSum(result, current, candidates, target - candidates[i], i);
            current.remove(current.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        cSum(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }
}