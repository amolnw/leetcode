class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> result = new ArrayList<>();
        int carry = 1;
        for(int i = digits.length-1; i >= 0; i--) {
            result.add(0, ( digits[i] + carry ) % 10);
            carry = ( digits[i] + carry ) / 10;
        }
        
        if ( carry == 1 ) {
            result.add(0, carry);
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}