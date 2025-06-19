class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int deficit = 0;
        int balance = 0;

        // index where we start
        int start = 0;

        for(int i = 0; i < gas.length; i++){
            balance = balance + gas[i] - cost[i];

            if(balance < 0){
                deficit += Math.abs(balance);
                start = i + 1;
                balance = 0;
            }
        }
        if(balance - deficit >= 0){
                return start;
            }
            else{
                return -1;
            }
    }
}