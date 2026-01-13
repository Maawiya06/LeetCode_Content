class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int half = (intLength + 1)/2;
        long start = (long) Math.pow(10, half - 1);
        long count = 9 * start;

        long[] ans = new long[queries.length];
        for(int i = 0; i < queries.length; i++){
            long k = queries[i];

            if(k > count){
                ans[i] = -1;
                continue;
            }

            long firsthalf = (start + k - 1);
            String s = Long.toString(firsthalf);
            StringBuilder sb = new StringBuilder(s);

            if(intLength % 2 == 0){
                sb.append(new StringBuilder(s).reverse());
            }
            else{
                sb.append(new StringBuilder(s.substring(0, s.length() - 1)).reverse());
            }
            ans[i] = Long.parseLong(sb.toString());
        }
        return ans;
    }
}