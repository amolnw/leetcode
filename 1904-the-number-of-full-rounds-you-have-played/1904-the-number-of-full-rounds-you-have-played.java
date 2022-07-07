class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        String[] loginTimeSplit = loginTime.split(":");
        String[] logoutTimeSplit = logoutTime.split(":");
        
        int login = Integer.parseInt(loginTimeSplit[0]) * 60 + Integer.parseInt(loginTimeSplit[1]);
        int logout = Integer.parseInt(logoutTimeSplit[0]) * 60 + Integer.parseInt(logoutTimeSplit[1]);
        
        if (login > logout) {
            logout += (24 * 60);
        }
        
        int result = -1;
        for(int i = login; i <= logout; i++) {
            if ( i%15 == 0 ) {
                result += 1;
            } 
        }
        
        return result == -1 ? 0 : result;
    }
}