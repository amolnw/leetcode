class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int numberOfDays = days[days.length-1] + 1;
        int[] dp = new int[numberOfDays];
        Set<Integer> daysSet = Arrays.stream(days).boxed().collect(Collectors.toSet());
        
        for(int i = 1; i < numberOfDays; i++) {
            if ( daysSet.contains(i) ) {
                dp[i] = Math.min(Math.min(dp[i-1] + costs[0], dp[Math.max(i-7, 0)] + costs[1]), dp[Math.max(i-30, 0)] + costs[2]);
            }
            else {
                dp[i] = dp[i-1];
            }
        }
        
        return dp[numberOfDays - 1];
    }
}