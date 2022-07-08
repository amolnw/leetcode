class Solution {

    double[] prefixSum;
    int totalSum = 0;
    
    public Solution(int[] w) {
        prefixSum = new double[w.length];
        for(int i = 0; i < w.length; i++) {
            totalSum += w[i];
            prefixSum[i] = totalSum;
        }
    }
    
    public int pickIndex() {
        int left = 0, right = prefixSum.length;
        double find = Math.random() * totalSum;
        while(left < right){
            int mid = left + ( right - left ) / 2;
            if ( prefixSum[mid] < find ) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */