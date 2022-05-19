class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(tx >= sx && ty >= sy){
            if ( tx == ty ) break; // Subtracting further will make 0
            if ( tx > ty && ty > sy ) { // Do mod if target y is > source y
                tx %= ty;
            }
            else if ( tx > ty ) { // Target y reached source y
                return ( tx - sx ) % ty == 0;
            }
            else if ( tx < ty && tx > sx ) {
                ty %= tx;
            }
            else { // Target x reached source x
                return ( ty - sy ) % tx == 0;
            }
        }
        
        return tx == sx && ty == sy;
    }
}