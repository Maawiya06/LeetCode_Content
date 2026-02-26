class Solution {
    public int numSteps(String s) {
        int step = 0;
        int carry = 0;

        for(int i = s.length() - 1; i > 0; i--){
            int bit = (s.charAt(i) - '0') + carry;

            if(bit == 1){
                step = step + 2;
                carry = 1;
            }
            else{
                step = step + 1;
            }
        }
        return step + carry;
    }
}